package data

class ProductosCRUD {

    private val productoManager = ProductosFirebase()

    fun agregarProductosDePrueba() {
        // Agregar 7 productos como si fueras una tienda de abarrotes
        productoManager.agregarProducto("001", "Arroz", 2.5, "Proveedor A", 50)
        productoManager.agregarProducto("002", "Frijoles", 3.0, "Proveedor B", 40)
        productoManager.agregarProducto("003", "Aceite", 5.0, "Proveedor C", 30)
        productoManager.agregarProducto("004", "Leche", 1.5, "Proveedor A", 60)
        productoManager.agregarProducto("005", "Pan", 2.0, "Proveedor B", 70)
        productoManager.agregarProducto("006", "Huevos", 4.0, "Proveedor C", 80)
        productoManager.agregarProducto("007", "Azúcar", 2.0, "Proveedor A", 45)
    }

    fun actualizarProductosDePrueba() {
        // Actualizar 3 productos
        productoManager.actualizarProducto("001", "Arroz Integral", 3.0, "Proveedor A", 55)
        productoManager.actualizarProducto("002", "Frijoles Refritos", 3.5, "Proveedor B", 35)
        productoManager.actualizarProducto("005", "Pan Integral", 2.5, "Proveedor B", 75)
    }

    fun eliminarProductosDePrueba() {
        // Eliminar 2 productos
        productoManager.eliminarProducto("003")
        productoManager.eliminarProducto("007")
    }

    fun obtenerProductos(completion: (List<Producto>) -> Unit) {
        val productosEjemplo: List<Producto> = listOf(
            Producto("001", "Aceite", 5.0, "Proveedor X", 50),
            Producto("002", "Arroz", 3.5, "Proveedor Y", 100),
            Producto("003", "Leche", 2.0, "Proveedor Z", 80),
            Producto("004", "Azúcar", 4.0, "Proveedor X", 60),
            Producto("005", "Sal", 1.0, "Proveedor Z", 70),
            Producto("006", "Café", 8.0, "Proveedor Y", 40),
            Producto("007", "Harina", 3.0, "Proveedor X", 90)
        )
        completion(productosEjemplo)
    }
}