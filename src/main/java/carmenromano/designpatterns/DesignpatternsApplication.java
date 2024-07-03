package carmenromano.designpatterns;
import carmenromano.designpatterns.adapter.Adapter;
import carmenromano.designpatterns.adapter.Info;
import carmenromano.designpatterns.adapter.UserData;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class DesignpatternsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesignpatternsApplication.class, args);
		Info info = new Info();
		info.setNome("Mario");
		info.setCognome("Rossi");

		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = dateFormat.parse("1980-10-05");
			info.DataDiNascita(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Adapter adapter = new Adapter(info);

		System.out.println("Nome Completo: " + adapter.getNomeCompleto());
		System.out.println("Età: " + adapter.getEta());
	}
}