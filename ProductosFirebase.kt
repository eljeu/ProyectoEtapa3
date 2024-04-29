package data

import com.google.firebase.database.*

class ProductosFirebase {

    private val database = FirebaseDatabase.getInstance()
    private val referenciaProductos = database.getReference("ProductosEtapa3")

    fun agregarProducto(codigo: String, nombre: String, precio: Double, provedor: String, unidades: Int) {
        val producto = Producto(codigo, nombre, precio, provedor, unidades)
        referenciaProductos.child(codigo).setValue(producto)
    }

    fun actualizarProducto(codigo: String, nombre: String, precio: Double, provedor: String, unidades: Int) {
        val producto = Producto(codigo, nombre, precio, provedor, unidades)
        referenciaProductos.child(codigo).setValue(producto)
    }

    fun eliminarProducto(codigo: String) {
        referenciaProductos.child(codigo).removeValue()
    }

    fun obtenerProductos(callback: (List<Producto>) -> Unit) {
        referenciaProductos.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val productos = mutableListOf<Producto>()
                for (childSnapshot in snapshot.children) {
                    val producto = childSnapshot.getValue(Producto::class.java)
                    producto?.let { productos.add(it) }
                }
                callback(productos)
            }

            override fun onCancelled(error: DatabaseError) {
            }
        })
    }
}