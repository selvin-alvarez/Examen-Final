package mi.examenFinal;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VentaDAO {
	
	private static final String URL = "jdbc:mariadb://localhost:3306/selvindb";
    private static final String USER = "root";
    private static final String PASSWORD = "SHAN1985";

    public void insertarVenta(Venta venta) throws SQLException {
        String sql = "INSERT INTO ventas (nombre, precio, cantidad, marca) VALUES (?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, venta.getNombre());
            stmt.setDouble(2, venta.getPrecio());
            stmt.setInt(3, venta.getCantidad());
            stmt.setString(4, venta.getMarca());
            stmt.executeUpdate();
        }
    }

    public List<Venta> obtenerVentas() throws SQLException {
        List<Venta> ventas = new ArrayList<>();
        String sql = "SELECT * FROM ventas";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Venta venta = new Venta(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getDouble("precio"),
                    rs.getInt("cantidad"),
                    rs.getString("marca")
                );
                ventas.add(venta);
            }
        }
        return ventas;
    }

    public void actualizarVenta(Venta venta) throws SQLException {
        String sql = "UPDATE ventas SET nombre = ?, precio = ?, cantidad = ?, marca = ? WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, venta.getNombre());
            stmt.setDouble(2, venta.getPrecio());
            stmt.setInt(3, venta.getCantidad());
            stmt.setString(4, venta.getMarca());
            stmt.setInt(5, venta.getId());
            stmt.executeUpdate();
        }
    }

    public void eliminarVenta(int id) throws SQLException {
        String sql = "DELETE FROM ventas WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}


