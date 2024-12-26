package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import database.Database;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.cell.PropertyValueFactory;
import model.AlatElektronik;
import model.Pelanggan;
import model.Penjualan;

public class HalamanUtamaController {
	//TextField, DatePicker, dan ComboBox
	@FXML
	private TextField fieldIdPelanggan;
	@FXML
	private TextField fieldNamaPelanggan;
	@FXML
	private TextField fieldEmailPelanggan;
	@FXML
	private TextField fieldTeleponPelanggan;
	
	@FXML
	private TextField fieldIdBarang;
	@FXML
	private TextField fieldNamaBarang;
	@FXML
	private TextField fieldMerekBarang;
	@FXML
	private TextField fieldHargaBarang;
	
	@FXML
	private TextField fieldIdPenjualan;
    @FXML
    private TextField fieldJumlah;
    @FXML
    private DatePicker pickTanggal;
    @FXML
    private ComboBox<String> comboIdBarang;
    @FXML
    private ComboBox<String> comboIdPelanggan;
	
	//TableView dan TableColumn
	@FXML
	private TableView<Pelanggan> tablePelanggan;
	@FXML
	private TableColumn<Pelanggan, String> clmIdPelanggan;
	@FXML
	private TableColumn<Pelanggan, String> clmNamaPelanggan;
	@FXML
	private TableColumn<Pelanggan, String> clmEmailPelanggan;
	@FXML
	private TableColumn<Pelanggan, String> clmTeleponPelanggan;
	
	@FXML
	private TableView<AlatElektronik> tableBarang;
	@FXML
	private TableColumn<AlatElektronik, String> clmIdBarang;
	@FXML
	private TableColumn<AlatElektronik, String> clmNamaBarang;
	@FXML
	private TableColumn<AlatElektronik, String> clmMerekBarang;
	@FXML
	private TableColumn<AlatElektronik, Long> clmHargaBarang;
	
	@FXML
	private TableView<Penjualan> tablePenjualan;
    @FXML
    private TableColumn<Penjualan, String> clmIdPenjualan;
    @FXML
    private TableColumn<Penjualan, Integer> clmJumlah;
    @FXML
    private TableColumn<Penjualan, Long> clmTotalHarga;
    @FXML
    private TableColumn<Penjualan, LocalDate> clmTanggalPenjualan;
    @FXML
    private TableColumn<Penjualan, String> clmIdPelangganFK;
    @FXML
    private TableColumn<Penjualan, String> clmIdBarangFK;
	
	//List
	private ObservableList<Pelanggan> dataPelanggan;
	private ObservableList<AlatElektronik> dataBarang;
	private ObservableList<Penjualan> dataPenjualan;
	
	@SuppressWarnings("unused")
	private Connection conn;
	
	@FXML
	public void initialize() {
		connectToDatabase();
		
		clmIdPelanggan.setCellValueFactory(new PropertyValueFactory<>("idPelanggan"));
		clmNamaPelanggan.setCellValueFactory(new PropertyValueFactory<>("namaPelanggan"));
		clmEmailPelanggan.setCellValueFactory(new PropertyValueFactory<>("email"));
		clmTeleponPelanggan.setCellValueFactory(new PropertyValueFactory<>("telepon"));
		
		clmIdBarang.setCellValueFactory(new PropertyValueFactory<>("idBarang"));
		clmNamaBarang.setCellValueFactory(new PropertyValueFactory<>("namaBarang"));
		clmMerekBarang.setCellValueFactory(new PropertyValueFactory<>("merek"));
		clmHargaBarang.setCellValueFactory(new PropertyValueFactory<>("harga"));
		
		clmIdPenjualan.setCellValueFactory(new PropertyValueFactory<>("idPenjualan"));
		clmJumlah.setCellValueFactory(new PropertyValueFactory<>("jumlah"));
		clmTotalHarga.setCellValueFactory(new PropertyValueFactory<>("totalHarga"));
		clmTanggalPenjualan.setCellValueFactory(new PropertyValueFactory<>("tanggal"));
		clmIdPelangganFK.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getPelanggan().getIdPelanggan()));
		clmIdBarangFK.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getAlatElektronik().getIdBarang()));
				
		tablePelanggan.setOnMouseClicked(event -> {
			Pelanggan selectedPelanggan = tablePelanggan.getSelectionModel().getSelectedItem();
			if(selectedPelanggan != null) {
				fieldIdPelanggan.setText(selectedPelanggan.getIdPelanggan());
				fieldNamaPelanggan.setText(selectedPelanggan.getNamaPelanggan());
				fieldEmailPelanggan.setText(selectedPelanggan.getEmail());
				fieldTeleponPelanggan.setText(selectedPelanggan.getTelepon());
			}
		});
		
		tableBarang.setOnMouseClicked(event -> {
			AlatElektronik selectedBarang = tableBarang.getSelectionModel().getSelectedItem();
			if(selectedBarang != null) {
				fieldIdBarang.setText(selectedBarang.getIdBarang());
				fieldNamaBarang.setText(selectedBarang.getNamaBarang());
				fieldMerekBarang.setText(selectedBarang.getMerek());
				fieldHargaBarang.setText(Long.toString(selectedBarang.getHarga()));
			}
		});
		
		tablePenjualan.setOnMouseClicked(event -> {
			Penjualan selectedPenjualan = tablePenjualan.getSelectionModel().getSelectedItem();
			if(selectedPenjualan != null) {
				fieldIdPenjualan.setText(selectedPenjualan.getIdPenjualan());
				fieldJumlah.setText(Integer.toString(selectedPenjualan.getJumlah()));
				pickTanggal.setValue(selectedPenjualan.getTanggal());
				comboIdPelanggan.setValue(selectedPenjualan.getPelanggan().getIdPelanggan());
				comboIdBarang.setValue(selectedPenjualan.getAlatElektronik().getIdBarang());
			}
		});
		
		loadDataPelanggan();
		loadDataBarang();
		loadDataPenjualan();
	}
	
	public void connectToDatabase() {
		try {
			conn = Database.connect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void showAlert(AlertType type, String title, String message) {
		Alert alert = new Alert(type);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.showAndWait();
	}
	
	public void loadDataPelanggan() {
		dataPelanggan = FXCollections.observableArrayList();
		ObservableList<String> listIdPelanggan = FXCollections.observableArrayList();
		
		try(Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery("SELECT * FROM pelanggan");
			){
				while(rs.next()) {
					String idPelanggan = rs.getString("ID_Pelanggan");
					String namaPelanggan = rs.getString("Nama_Pelanggan");
					String email = rs.getString("Email");
					String telepon = rs.getString("Telepon");
					
					listIdPelanggan.add(idPelanggan);
					dataPelanggan.add(new Pelanggan(idPelanggan,namaPelanggan,email,telepon));
				}
				
				comboIdPelanggan.setItems(listIdPelanggan);
				tablePelanggan.setItems(dataPelanggan);
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void loadDataBarang() {
		dataBarang = FXCollections.observableArrayList();
		ObservableList<String> listIdBarang = FXCollections.observableArrayList();
		
		try(Statement stat = conn.createStatement();
				ResultSet rs = stat.executeQuery("SELECT * FROM alat_elektronik");
				){
			while(rs.next()) {
				String idBarang = rs.getString("ID_Barang");
				String namaBarang = rs.getString("Nama_Barang");
				String merek = rs.getString("Merek");
				Long harga = rs.getLong("Harga");
				
				listIdBarang.add(idBarang);
				dataBarang.add(new AlatElektronik(idBarang,namaBarang,merek,harga));
			}
			
			comboIdBarang.setItems(listIdBarang);
			tableBarang.setItems(dataBarang);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void loadDataPenjualan() {
		dataPenjualan = FXCollections.observableArrayList();
	    
	    String query = """
	        SELECT p.ID_Penjualan, p.Jumlah, p.Total_Harga, p.Tanggal, 
	               pl.ID_Pelanggan, pl.Nama_Pelanggan, pl.Email, pl.Telepon, 
	               b.ID_Barang, b.Nama_Barang, b.Merek, b.Harga
	        FROM penjualan p
	        LEFT JOIN pelanggan pl ON p.ID_Pelanggan = pl.ID_Pelanggan
	        LEFT JOIN alat_elektronik b ON p.ID_Barang = b.ID_Barang
	    """;

	    try (Statement stat = conn.createStatement();
	         ResultSet rs = stat.executeQuery(query)) {

	        while (rs.next()) {
	            String idPenjualan = rs.getString("ID_Penjualan");
	            int jumlah = rs.getInt("Jumlah");
	            Long totalHarga = rs.getLong("Total_Harga");
	            LocalDate tanggal = rs.getDate("Tanggal").toLocalDate();

	            Pelanggan pelanggan = new Pelanggan(
	                rs.getString("ID_Pelanggan"),
	                rs.getString("Nama_Pelanggan"),
	                rs.getString("Email"),
	                rs.getString("Telepon")
	            );

	           AlatElektronik barang = new AlatElektronik(
	                rs.getString("ID_Barang"),
	                rs.getString("Nama_Barang"),
	                rs.getString("Merek"),
	                rs.getLong("Harga")
	            );

	            dataPenjualan.add(new Penjualan(idPenjualan, jumlah, totalHarga, tanggal, pelanggan, barang));
	        }

	        tablePenjualan.setItems(dataPenjualan);

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	@FXML
	public void addDataPelanggan() {
		String idPelanggan = fieldIdPelanggan.getText();
		String namaPelanggan = fieldNamaPelanggan.getText();
		String email = fieldEmailPelanggan.getText();
		String telepon = fieldTeleponPelanggan.getText();
		
		String query = "INSERT INTO pelanggan (ID_Pelanggan, Nama_Pelanggan, Email, Telepon) VALUES (?, ?, ?, ?)";
		
		if(idPelanggan.isEmpty()) {
			showAlert(AlertType.ERROR, "Peringatan", "ID Pelanggan tidak boleh kosong");
		}
		else {
			try (PreparedStatement stat =  conn.prepareStatement(query);
					){
				stat.setString(1, idPelanggan);
				stat.setString(2, namaPelanggan);
				stat.setString(3, email);
				stat.setString(4, telepon);
				stat.executeUpdate();
				
			} catch (Exception e) {
				showAlert(AlertType.ERROR, "Peringatan", e.getMessage());
			}
		}
		
		loadDataPelanggan();
	}
	
	@FXML
	public void addDataBarang() {
		String idBarang = fieldIdBarang.getText();
		String namaBarang = fieldNamaBarang.getText();
		String merek = fieldMerekBarang.getText();
		Long harga;
		if(fieldHargaBarang.getText().isEmpty() || Long.valueOf(fieldHargaBarang.getText()) < 0) {
			harga = 0l;
		}
		else {
			harga = Long.valueOf(fieldHargaBarang.getText());
		}
		
		String query = "INSERT INTO alat_elektronik (ID_Barang, Nama_Barang, Merek, Harga) VALUES (?, ?, ?, ?)";
		
		if(idBarang.isEmpty()) {
			showAlert(AlertType.ERROR, "Peringatan", "ID Barang tidak boleh kosong");
		}
		else {
			try (PreparedStatement stat =  conn.prepareStatement(query);
					){
				stat.setString(1, idBarang);
				stat.setString(2, namaBarang);
				stat.setString(3, merek);
				stat.setLong(4, harga);
				stat.executeUpdate();
				
			} catch (Exception e) {
				showAlert(AlertType.ERROR, "Peringatan", e.getMessage());
			}
		}
		
		loadDataBarang();
	}
	
	@FXML
	public void addDataPenjualan() {	
		String idPenjualan = fieldIdPenjualan.getText();
		int jumlah;
		if(fieldJumlah.getText().isEmpty() || Integer.valueOf(fieldJumlah.getText()) < 0) {
			jumlah = 0;
		}
		else {
			jumlah = Integer.valueOf(fieldJumlah.getText());
		}
		Date tanggal = pickTanggal.getValue() == null ? Date.valueOf(LocalDate.now()) : Date.valueOf(pickTanggal.getValue());
		String idPelanggan = comboIdPelanggan.getValue();
		String idBarang = comboIdBarang.getValue();
		
		Long hargaBarang = 0l;
		try (PreparedStatement state = conn.prepareStatement("SELECT * FROM alat_elektronik WHERE Id_Barang = ?")) {
			state.setString(1, comboIdBarang.getValue());
			ResultSet rs = state.executeQuery();
			if (rs.next()) {
				hargaBarang = rs.getLong("Harga");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Long totalharga = jumlah * hargaBarang;
		String query = "INSERT INTO Penjualan (ID_Penjualan, Jumlah, Total_Harga, Tanggal, ID_Pelanggan, ID_Barang) VALUES (?, ?, ?, ?, ?, ?)";
		
		if(idPenjualan.isEmpty()) {
			showAlert(AlertType.ERROR, "Peringatan", "ID Penjualan tidak boleh kosong");
		}
		else {
			try (PreparedStatement stat =  conn.prepareStatement(query);
					){
				stat.setString(1, idPenjualan);
				stat.setInt(2, jumlah);
				stat.setLong(3, totalharga);
				stat.setDate(4, tanggal);
				stat.setString(5, idPelanggan);
				stat.setString(6, idBarang);
				stat.executeUpdate();
				
			} catch (Exception e) {
				showAlert(AlertType.ERROR, "Peringatan", e.getMessage());
			}
		}
		
		loadDataPenjualan();
	}
	
	@FXML
	public void updateDataPelanggan() {
		Pelanggan selectedPelanggan = tablePelanggan.getSelectionModel().getSelectedItem();
		String query = "UPDATE pelanggan SET ID_Pelanggan = ?, Nama_Pelanggan = ?, Email = ?, Telepon = ? WHERE ID_Pelanggan = ?";
		
		String idPelanggan = fieldIdPelanggan.getText();
		String namaPelanggan = fieldNamaPelanggan.getText();
		String email = fieldEmailPelanggan.getText();
		String telepon = fieldTeleponPelanggan.getText();
		
		if(idPelanggan.isEmpty()) {
			showAlert(AlertType.ERROR, "Peringatan", "ID Pelanggan tidak boleh kosong");
		}
		else {
			try (PreparedStatement stat = conn.prepareStatement(query);
					){
				stat.setString(1, idPelanggan);
				stat.setString(2, namaPelanggan);
				stat.setString(3, email);
				stat.setString(4, telepon);
				stat.setString(5, selectedPelanggan.getIdPelanggan());
				stat.executeUpdate();
				
			} catch (Exception e) {
				showAlert(AlertType.ERROR, "Peringatan", e.getMessage());
			}
		}
		
		loadDataPelanggan();
	}
	
	@FXML
	public void updateDataBarang() {
		AlatElektronik selectedBarang = tableBarang.getSelectionModel().getSelectedItem();
		String query = "UPDATE alat_elektronik SET ID_Barang = ?, Nama_Barang = ?, Merek = ?, Harga = ? WHERE ID_Barang = ?";
		
		String idBarang = fieldIdBarang.getText();
		String namaBarang = fieldNamaBarang.getText();
		String merek = fieldMerekBarang.getText();
		Long harga = fieldHargaBarang.getText().isEmpty() ? 0l : Long.valueOf(fieldHargaBarang.getText());
		
		if(idBarang.isEmpty()) {
			showAlert(AlertType.ERROR, "Peringatan", "ID Barang tidak boleh kosong");
		}
		else {
			try (PreparedStatement stat = conn.prepareStatement(query);
					){
				stat.setString(1, idBarang);
				stat.setString(2, namaBarang);
				stat.setString(3, merek);
				stat.setLong(4, harga);
				stat.setString(5, selectedBarang.getIdBarang());
				stat.executeUpdate();
				
			} catch (Exception e) {
				showAlert(AlertType.ERROR, "Peringatan", e.getMessage());
			}
		}
		
		loadDataBarang();
	}
	
	@FXML
	public void updateDataPenjualan() {
		Penjualan selectedPenjualan = tablePenjualan.getSelectionModel().getSelectedItem();
		String query = "UPDATE penjualan SET ID_Penjualan = ?, Jumlah = ?, Total_Harga = ?, Tanggal = ?, ID_Pelanggan = ?, ID_Barang = ? WHERE ID_Penjualan = ?";
		
		String idPenjualan = fieldIdPenjualan.getText();
		int jumlah = fieldJumlah.getText().isEmpty() ? 0 : Integer.valueOf(fieldJumlah.getText());
		Date tanggal = pickTanggal.getValue() == null ? Date.valueOf(LocalDate.now()) : Date.valueOf(pickTanggal.getValue());
		String idPelanggan = comboIdPelanggan.getValue();
		String idBarang = comboIdBarang.getValue();
		
		Long hargaBarang = 0l;
		try (PreparedStatement state = conn.prepareStatement("SELECT * FROM alat_elektronik WHERE Id_Barang = ?")) {
			state.setString(1, comboIdBarang.getValue());
			ResultSet rs = state.executeQuery();
			if (rs.next()) {
				hargaBarang = rs.getLong("Harga");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Long totalharga = jumlah * hargaBarang;
		
		if(idPenjualan.isEmpty()) {
			showAlert(AlertType.ERROR, "Peringatan", "ID Penjualan tidak boleh kosong");
		}
		else {
			try(PreparedStatement stat = conn.prepareStatement(query);
			) {
				stat.setString(1, idPenjualan);
				stat.setInt(2, jumlah);
				stat.setLong(3, totalharga);
				stat.setDate(4, tanggal);
				stat.setString(5, idPelanggan);
				stat.setString(6, idBarang);
				stat.setString(7, selectedPenjualan.getIdPenjualan());
				stat.executeUpdate();
			}
			catch(Exception e) {
				showAlert(AlertType.ERROR, "Peringatan", e.getMessage());
			}
		}
		
		loadDataPenjualan();
	}
	
	@FXML
	public void deleteDataPelanggan() {
		Pelanggan selectedKue = tablePelanggan.getSelectionModel().getSelectedItem();
		String query = "DELETE FROM pelanggan WHERE ID_Pelanggan = ?";
		
		try(PreparedStatement stat = conn.prepareStatement(query);
		) {
			String idPelanggan = selectedKue.getIdPelanggan();
			stat.setString(1, idPelanggan);
			stat.executeUpdate();
			
		} catch (Exception e) {
			showAlert(AlertType.ERROR, "Peringatan", e.getMessage());
		}
		
		loadDataPelanggan();
	}
	
	@FXML
	public void deleteDataBarang() {
		AlatElektronik selectedBarang = tableBarang.getSelectionModel().getSelectedItem();
		String query = "DELETE FROM alat_elektronik WHERE ID_Barang = ?";
		
		try(PreparedStatement stat = conn.prepareStatement(query);
				) {
			String idPelanggan = selectedBarang.getIdBarang();
			stat.setString(1, idPelanggan);
			stat.executeUpdate();
			
		} catch (Exception e) {
			showAlert(AlertType.ERROR, "Peringatan", e.getMessage());
		}
		
		loadDataBarang();
	}
	
	@FXML
	public void deleteDataPenjualan() {
		Penjualan selectedPenjualan = tablePenjualan.getSelectionModel().getSelectedItem();
		String query = "DELETE FROM penjualan WHERE ID_Penjualan = ?";
		
		try(PreparedStatement stat = conn.prepareStatement(query);
		){
			String idPenjualan = selectedPenjualan.getIdPenjualan();
			stat.setString(1, idPenjualan);
			stat.executeUpdate();
			
		} catch (Exception e) {
			showAlert(AlertType.ERROR, "Peringatan", e.getMessage());
		}
		
		loadDataPenjualan();
	}
	
	@FXML
	public void clearFieldPelanggan() {
		fieldIdPelanggan.clear();
		fieldNamaPelanggan.clear();
		fieldEmailPelanggan.clear();
		fieldTeleponPelanggan.clear();
	}
	
	@FXML
	public void clearFieldBarang() {
		fieldIdBarang.clear();
		fieldNamaBarang.clear();
		fieldMerekBarang.clear();
		fieldHargaBarang.clear();
	}
	
	@FXML
	public void clearFieldPenjualan() {
		fieldIdPenjualan.clear();
		fieldJumlah.clear();
		pickTanggal.setValue(null);
		comboIdPelanggan.setValue(null);
		comboIdBarang.setValue(null);
	}
}
