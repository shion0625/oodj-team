package people;

import Class.VaccinationStatusView;
import Class.VaccinationStatusSearch;

import java.io.File;


public class VaccinationStatus {
    public VaccinationStatus() {
    }

    public void View() {
        VaccinationStatusView vaccinationStatusView = new VaccinationStatusView();
        vaccinationStatusView.StatusView();
    }

    public void Search(String value) {
        VaccinationStatusSearch vaccinationStatusSearch = new VaccinationStatusSearch();
        vaccinationStatusSearch.StatusSearch(value);
    }
}
