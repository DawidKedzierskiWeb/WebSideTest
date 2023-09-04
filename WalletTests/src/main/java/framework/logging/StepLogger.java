package framework.logging;

import com.capgemini.mrchecker.test.core.logger.BFLogger;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.jsoup.Jsoup;

public final class StepLogger {
	
	@Step("{message}")
	public static void logStep(String message) {
		BFLogger.logInfo(message);
	}
	
	public static void logStep(String format, Object... args) {
		logStep(String.format(format, args));
	}
	
	@Attachment(value = "{attachName}", type = "text/plain")
	public static String saveTextAttachmentToLog(String attachName, String message) {
		BFLogger.logInfo(attachName.toUpperCase() + ":\n" + message);
		return message;
	}
	
	public static void saveEmailToLog(String attachName, String message) {
		var msg = message.replaceAll("<br/>", "&#13;");
		msg = msg.replaceAll("<br>", "&#13;");
		msg = Jsoup.parse(msg)
				.text();
		saveTextAttachmentToLog(attachName, msg);
	}
}
