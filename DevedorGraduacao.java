package trabalhofinal;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DevedorGraduacao implements Devedor {

    public boolean devedor(Usuario usu) {

        while (usu.itr.hasNext()) {
            Livro key = usu.itr.next();
            Long dias = ChronoUnit.DAYS.between(usu.getDataEmprestimo(key), LocalDate.now());
            if (dias > 3) {
                return true;
            }
        }
        return false;
    }
}
