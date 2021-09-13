package pom.grupo1.test;

import org.junit.Assert;
import org.junit.Test;
import pom.grupo1.Pages.VFAlojamientosPage;
import pom.grupo1.Pages.VFHomePage;
import pom.grupo1.base.TestBase;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class atc03_alojamientoMultiRoom extends TestBase {

    final String DESTINO = "santiago";
    final String YEAR_MONTH = "2021-10"; // aaaa-mm
    final String ENTRADA_DAY = "1";
    final String SALIDA_DAY = "15";
    final String CHILDREN_AGE = "10";

    @Test
    public void atc03() {
        VFHomePage home = new VFHomePage(driver);
        home.goToHome();
        home.goToAlojamientos();

        VFAlojamientosPage alojamientos = new VFAlojamientosPage(driver);
        alojamientos.selectDestino(DESTINO);
        alojamientos.selectEntradaDates(YEAR_MONTH, ENTRADA_DAY, SALIDA_DAY);

        alojamientos.addRoom();
        alojamientos.selectAdultsAmount();
        alojamientos.selectChildrenAmount();
        alojamientos.setChildrenAge(CHILDREN_AGE, 2);

        alojamientos.makeSearch();
        alojamientos.waitForResultsPage(DESTINO);

        Assert.assertEquals(2, alojamientos.getRoomsAmount());
    }
}
