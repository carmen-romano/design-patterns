package carmenromano.designpatterns.adapter;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;

public class Adapter implements DataSource {
    private Info info;

    public Adapter(Info info) {
        this.info = info;
    }

    @Override
    public String getNomeCompleto() {
        return info.getNome() + " " + info.getCognome();
    }

        @Override
        public int getEta() {
            LocalDate birthDate = info.getDataDiNascita().toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate();
            LocalDate currentDate = LocalDate.now();
            int eta = Period.between(birthDate, currentDate).getYears();
            return eta;
        }

    }

