package praktikum6;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TableViewController {
	@FXML
	private TableView<Mahasiswa> tabelMahasiswa;
		
	@FXML
	private TableColumn<Mahasiswa, String> kolomNama;
	
	@FXML
	private TableColumn<Mahasiswa, String> kolomNIM;
	
	public void initialize() {
		kolomNama.setCellValueFactory(new PropertyValueFactory<>("nama"));
		kolomNIM.setCellValueFactory(new PropertyValueFactory<>("nim"));
		
		ObservableList<Mahasiswa> dataMahasiswa = FXCollections.observableArrayList(
			new Mahasiswa(101, "Muhammad Raihan", "2310817110008"),
			new Mahasiswa(102, "Muhammad Rizki Ramadhan", "2310817310008"),
			new Mahasiswa(103, "Muhammad Rizki Saputra", "2310817310014"),
			new Mahasiswa(104, "Muhammad Rizky", "2310817310011"),
			new Mahasiswa(105, "Naila Hanifah", "2310817220016"),
			new Mahasiswa(106, "Natalie Grace Katiandagho", "2310817120003"),
			new Mahasiswa(107, "Naufal Elyzar", "2310817210019"),
			new Mahasiswa(108, "Nazmi Hakim", "2310817210012"),
			new Mahasiswa(109, "Noviana Nur Aisyah", "2310817120005"),
			new Mahasiswa(110, "Nur Hikmah", "2310817120010")
		);
		
		tabelMahasiswa.setItems(dataMahasiswa);
	}
}
