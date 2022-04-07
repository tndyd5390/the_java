package me.waterdragon;

import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.Name;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;

import com.google.auto.service.AutoService;

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
		}

		//이 어노테이션을 여기서만 처리할거면 true 다른곳에서도 처리할거면 false
		return true;
	}
}
