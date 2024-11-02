package mi.examenFinal;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        VentaDAO ventaDAO = new VentaDAO();

        // Insertar una nueva venta
        Venta nuevaVenta = new Venta(0, "Laptop", 1200.00, 10, "Dell");
        try {
            ventaDAO.insertarVenta(nuevaVenta);
            System.out.println("Venta insertada correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Obtener y mostrar todas las ventas
        try {
            List<Venta> ventas = ventaDAO.obtenerVentas();
            for (Venta venta : ventas) {
                System.out.println(venta);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Actualizar una venta
        Venta ventaActualizada = new Venta(1, "Laptop", 1100.00, 8, "HP");
        try {
            ventaDAO.actualizarVenta(ventaActualizada);
            System.out.println("Venta actualizada correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Eliminar una venta
        try {
            ventaDAO.eliminarVenta(1);
            System.out.println("Venta eliminada correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}