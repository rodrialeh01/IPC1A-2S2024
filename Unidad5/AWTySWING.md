# 🤓 AWT y Swing
>Creado por: Rodrigo Hernández para el laboratorio de Introducción a la Programación y Computación 1.

En este archivo se abordarán los temas de AWT y Swing, los cuales son herramientas muy útiles para la creación de interfaces gráficas en Java.

## ¿Qué es AWT y Swing?

- AWT (Abstract Window Toolkit) es la biblioteca gráfica original de Java, diseñada para crear interfaces de usuario básicas. Proporciona componentes simples como botones y cuadros de texto, y utiliza las bibliotecas nativas del sistema operativo, lo que hace que los componentes de AWT dependan de la apariencia y el comportamiento del sistema operativo. Esta dependencia limita su personalización y hace que las interfaces se vean diferentes en cada plataforma.

- Swing, por otro lado, es una extensión de AWT introducida posteriormente, que ofrece componentes más avanzados y una mayor flexibilidad. A diferencia de AWT, Swing es independiente del sistema operativo, lo que permite una apariencia y funcionalidad uniforme en todas las plataformas. Además, Swing ofrece una amplia gama de componentes adicionales, como tablas y árboles, y permite personalizar el "look and feel" de la interfaz, haciendo posible la creación de interfaces más complejas y adaptables.

## Creación de Interfaces Gráficas usando Swing

### Ventana: JFrame

#### Opcion 1:

En esta opción creamos el objeto JFrame.

```java
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.awt.*;
public class MiPrograma {
    public static void main(String[] args) {
        //Creamos el objeto Ventana
        JFrame ventana = new JFrame("Mi Ventana");
        //Cambiamos el tamaño de nuestra ventana
        ventana.setSize(400, 300);
        //Configuramos que al cerrar la ventana, termine la ejecución del sistema
        ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //Hacemos visible la ventana
        ventana.setVisible(true);
    }
}
```

#### Opcion 2:

En esta opción heredamos el objeto JFrame a una clase que nosotros creamos.

- Nuestra clase que será una ventana:
    ```java
    import javax.swing.JFrame;
    import javax.swing.WindowConstants;
    import java.awt.*;

    public class MiVentana extends JFrame {
        public MiVentana() {
            //Configuramos el título de la ventana
            this.setTitle("Mi Ventana");
            //Cambiamos el tamaño de nuestra ventana
            this.setSize(400, 300);
            //Configuramos que al cerrar la ventana, termine la ejecución del sistema
            this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            //Hacemos visible la ventana
            this.setVisible(true);
        }
    }
    ```
- Lo llamamos a nuestra Main:
    ```java
    public class MiPrograma {
        public static void main(String[] args) {
            //Creamos el objeto Ventana
            MiVentana ventana = new MiVentana();
        }
    }
    ```
### Componentes
#### Etiquetas: JLabel
```java
import javax.swing.*;

public class MiVentana extends JFrame {
    public MiVentana() {
        //Configuramos el título de la ventana
        this.setTitle("Mi Ventana");
        //Cambiamos el tamaño de nuestra ventana
        this.setSize(400, 300);
        //Configuramos que al cerrar la ventana, termine la ejecución del sistema
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //Hacemos visible la ventana
        this.setVisible(true);

        //Creamos una etiqueta
        JLabel etiqueta = new JLabel("Hola Mundo");
        //Agregamos la etiqueta a la ventana
        this.add(etiqueta);
    }
}
```

#### Botones: JButton
```java
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Llamamos al ActionListener para ejecutar funcionalidades al botón

public class MiVentana extends JFrame implements ActionListener{
    JButton boton;
    public MiVentana() {
        //Configuramos el título de la ventana
        this.setTitle("Mi Ventana");
        //Cambiamos el tamaño de nuestra ventana
        this.setSize(400, 300);
        //Configuramos que al cerrar la ventana, termine la ejecución del sistema
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //Hacemos visible la ventana
        this.setVisible(true);

        //Creamos una botón
        boton = new JButton("Haz Click");
        //Agregamos que el actionlistener haga efecto en el botón
        boton.addActionListener(this);
        //Agregamos el botón a la ventana
        this.add(boton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == boton){
            System.out.println("Haz hecho click en el botón");
        }
    }

}
```

#### Campos de Texto: JTextField
```java
import javax.swing.*;

public class MiVentana extends JFrame {
    JTextField campoTexto;
    public MiVentana() {
        //Configuramos el título de la ventana
        this.setTitle("Mi Ventana");
        //Cambiamos el tamaño de nuestra ventana
        this.setSize(400, 300);
        //Configuramos que al cerrar la ventana, termine la ejecución del sistema
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //Hacemos visible la ventana
        this.setVisible(true);

        //Creamos un campo de texto
        campoTexto = new JTextField();
        //Agregamos el campo de texto a la ventana
        this.add(campoTexto);
    }
}
```

#### Paneles: JPanel
```java
import javax.swing.*;
import java.awt.*;

public class MiVentana extends JFrame {
    JPanel panel;
    public MiVentana() {
        //Configuramos el título de la ventana
        this.setTitle("Mi Ventana");
        //Cambiamos el tamaño de nuestra ventana
        this.setSize(400, 300);
        //Configuramos que al cerrar la ventana, termine la ejecución del sistema
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //Hacemos visible la ventana
        this.setVisible(true);

        //Creamos un panel
        panel = new JPanel();
        //Configuramos el color de fondo del panel
        panel.setBackground(Color.BLUE);
        //Agregamos el panel a la ventana
        this.add(panel);
    }
}
```

Y estos son componentes básicos, si quieres ver como crear más componentes te puede servir el siguiente Material de apoyo [para Swing](./Apoyo/2.-%20Java%20foundation%20Classes%20(Swing).pdf) y [para AWT](./Apoyo/1.-%20El%20paquete%20AWT.pdf).