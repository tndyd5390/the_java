package me.waterdragon;

import java.io.IOException;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.Name;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;

import com.google.auto.service.AutoService;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

@AutoService(Processor.class)
public class MagicMojaProcessor extends AbstractProcessor {

	@Override
	public Set<String> getSupportedAnnotationTypes() {
		return Set.of(Magic.class.getName());
	}

	@Override
	public SourceVersion getSupportedSourceVersion() {
		return SourceVersion.latestSupported();
	}

	@Override
	public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
		Set<? extends Element> elements = roundEnv.getElementsAnnotatedWith(
			Magic.class);
		for (Element element : elements) {
			Name elementName = element.getSimpleName();
			if (element.getKind() == ElementKind.INTERFACE) {
				processingEnv.getMessager().printMessage(Diagnostic.Kind.NOTE,
					"processing " + elementName);
			} else {
				processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, "Magic annotation"
					+ " can not be used on " + elementName);
			}

			//여기서부터 javapoet
			//클래스 이름 가져오기
			TypeElement typeElement = (TypeElement)element;
			ClassName className = ClassName.get(typeElement);

			//메소드 만들기
			MethodSpec pullOut = MethodSpec.methodBuilder("pullOut")
				.addModifiers(Modifier.PUBLIC)
				.returns(String.class)
				.addStatement("return $S", "rabbit")
				.build();

			//클래스 만들기
			TypeSpec magicMoja = TypeSpec.classBuilder("MagicMoja")
				.addModifiers(Modifier.PUBLIC)
				.addSuperinterface(className)
				.addMethod(pullOut)
				.build();

			//소스 파일 만들기
			Filer filer = processingEnv.getFiler();

			//magicMoja라는 타입을 저 패키지 않에 만들어라
			try {
				JavaFile.builder(className.packageName(), magicMoja).build().writeTo(filer);
			} catch (IOException e) {
				processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR,
					"FATAL ERROR: " + e.getMessage());
			}
		}

		//이 어노테이션을 여기서만 처리할거면 true 다른곳에서도 처리할거면 false
		return true;
	}
}
