package mi.examenFinal;

public class Venta {
	
	 private int id;
	    private String nombre;
	    private double precio;
	    private int cantidad;
	    private String marca;

	    // Constructor, getters y setters
	    public Venta(int id, String nombre, double precio, int cantidad, String marca) {
	        this.id = id;
	        this.nombre = nombre;
	        this.precio = precio;
	        this.cantidad = cantidad;
	        this.marca = marca;
	    }
	    
	    // Getters y setters

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public double getPrecio() {
			return precio;
		}

		public void setPrecio(double precio) {
			this.precio = precio;
		}

		public int getCantidad() {
			return cantidad;
		}

		public void setCantidad(int cantidad) {
			this.cantidad = cantidad;
		}

		public String getMarca() {
			return marca;
		}

		public void setMarca(String marca) {
			this.marca = marca;
		}

	  
	}


