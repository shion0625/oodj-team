package people;

import Class.VaccinationStatusView;
import Class.VaccinationStatusSearch;


public class ViewVaccinationStatus {
    public ViewVaccinationStatus() {
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
