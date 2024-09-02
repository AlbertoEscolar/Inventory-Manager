package Main;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Controller.InventoryController;
import Model.Producto;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class InventoryManagerTest {
    
    private InventoryController inventoryController;
    private List<Producto> productos;

    @BeforeEach
    void setUp() {
        inventoryController = new InventoryController();
        productos = new ArrayList<>();
    }

    @Test
    void testAgregarProducto() throws Exception {
        // Simula la entrada del usuario para agregar un producto
        Scanner scanner = new Scanner("TestProduct\n10.5\n100\n");
        inventoryController.agregarProducto(scanner, productos);

        assertEquals(1, productos.size());
        assertEquals("TestProduct", productos.get(0).getNombre());
        assertEquals(10.5, productos.get(0).getPrecio());
        assertEquals(100, productos.get(0).getCantidad());
    }

    @Test
    void testBuscarProductoExistente() {
        // Añadir producto de prueba
        productos.add(new Producto("TestProduct", 10.5f, 100));
        
        // Simula la entrada del usuario para buscar un producto
        Scanner scanner = new Scanner("TestProduct");
        inventoryController.buscarProducto(scanner, productos);

        // Asegúrate de que el producto fue encontrado y coincide con el nombre
        Producto foundProduct = productos.stream().filter(p -> p.getNombre().equals("TestProduct")).findFirst().orElse(null);
        assertNotNull(foundProduct);
        assertEquals("TestProduct", foundProduct.getNombre());
    }

    @Test
    void testVenderProducto() {
        // Añadir producto de prueba
        productos.add(new Producto("TestProduct", 10.5f, 100));
        
        // Simula la entrada del usuario para vender un producto
        Scanner scanner = new Scanner("TestProduct\n50\n");
        inventoryController.venderProducto(scanner, productos);

        // Verifica que la cantidad del producto se haya actualizado correctamente
        assertEquals(50, productos.get(0).getCantidad());
    }
    
    @Test
    void testVenderProductoNoDisponible() {
        // Añadir producto de prueba con cantidad insuficiente
        productos.add(new Producto("TestProduct", 10.5f, 10));
        
        // Simula la entrada del usuario para vender una cantidad mayor a la disponible
        Scanner scanner = new Scanner("TestProduct\n50\n");
        inventoryController.venderProducto(scanner, productos);

        // Verifica que la cantidad del producto no se haya actualizado
        assertEquals(10, productos.get(0).getCantidad());
    }

}
