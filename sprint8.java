import java.util.Scanner;

public class sprint8 {
    public static void main(String[] args) {
        final int minId = 111;
        final int maxId = 999;
        final int minEdad = 14;
        final int maxEdad = 120;
        final int minTipoVenta = 0;
        final int maxTipoVenta = 3;
        final int minCompra = 0;
        final int maxCompra = 1000;
        final int minTelefono = 111111111;
        final int maxTelefono = 999999999;

        Scanner teclado = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            boolean error = false;

            int id = obtenerDatoConReintentos("Introduce tu ID: ", minId, maxId);
            if (id == -1) {
                error = true;
                mensajeError();
            }

            int edad = 0;
            if (!error) {
                edad = obtenerDatoConReintentos("Introduce tu edad: ", minEdad, maxEdad);
                if (edad == -1) {
                    error = true;
                    mensajeError();
                }
            }

            int tipoVenta = 0;
            if (!error) {
                System.out.println("Introduce el código del tipo de venta (venta libre: 0; pensionista: 1; carnet joven: 2; socio: 3): ");
                tipoVenta = teclado.nextInt();
                if (tipoVenta < minTipoVenta || tipoVenta > maxTipoVenta) {
                    error = true;
                    mensajeError();
                }
            }

            int importeCompra = 0;
            if (!error) {
                importeCompra = obtenerDatoConReintentos("Introduce el importe de compra: ", minCompra, maxCompra);
                if (importeCompra == -1) {
                    error = true;
                    mensajeError();
                }
            }

            int telefono = 0;
            if (!error) {
                telefono = obtenerDatoConReintentos("Introduce un teléfono de contacto: ", minTelefono, maxTelefono);
                if (telefono == -1) {
                    error = true;
                    mensajeError();
                }
            }

            if (!error) {
                String tipoVentaTexto = switch (tipoVenta) {
                    case 0 -> "venta libre";
                    case 1 -> "pensionista";
                    case 2 -> "carnet joven";
                    case 3 -> "socio";
                    default -> "Tipo de venta desconocido.";
                };

                System.out.println("Los datos introducidos son válidos.");
                System.out.printf("%-10s%-10s%-15s%-20s%-15s%n", "ID", "edad", "tipo de venta", "importe de compra", "teléfono");
                System.out.printf("%-10d%-10d%-15s%-20d%-15d%n", id, edad, tipoVentaTexto, importeCompra, telefono);
            }

            // Pregunta si quiere introducir los datos de otro cliente
            System.out.println("¿Deseas introducir los datos de otro cliente? (s/n): ");
            String respuesta = teclado.next();
            if (!respuesta.equalsIgnoreCase("s")) {
                continuar = false;
            }
        }
    }

    private static int obtenerDatoConReintentos(String mensaje, int min, int max) {
        Scanner teclado = new Scanner(System.in);
        int intentos = 0;
        int dato = -1;
        
        while (intentos < 3) {
            System.out.print(mensaje);
            dato = teclado.nextInt();
            if (dato >= min && dato <= max) {
                return dato;
            }
            intentos++;
            mensajeError();
        }
        
        return -1; // Retorna -1 si los intentos fallan
    }

    private static void mensajeError() {
        System.out.println("Datos introducidos inválidos. Por favor, verifica la información.");
    }
}
