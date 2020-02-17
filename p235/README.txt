Para un juego de domino se requiere colocar las fichas a partir de la pieza inicial, como las piezas se pueden colocar a la izquierda o a la derecha de la pieza inicial vamos a construir una lista doblemente ligada que nos permita colocar las nuevas fichas sobre el tablero. Si el tablero empieza con la ficha 6 6, el primer nodo del tablero deberá guardar los valores de la fichas, es decir un seis de cada lado de la ficha, si la ficha que sigue por tirar es un 6 4, la ficha puede colocarse tanto a la izquierda como a la derecha sin problema dejando el 4 libre para poder seguir jugando por ese lado. La entrada define en su primer renglón el numero de casos para determinar si las fichas se pueden colocar sin problemas en la mesa y a continuación en cada renglón viene un conjunto de fichas para intentar colocarlas en la lista doble ligada. las fichas están separadas por espacios, la salida debe imprimir por cada renglón leído "OK" si las fichas se pueden colocar consecutivamente sin errores y "NOK" en caso caso de que se detecten errores en la secuencia.

Las restricciones del programa son:

No se pueden tirar fichas repetidas.
No se deben colocar fichas que no empaten con ningún lado del tablero (imprimir NOK). 
Es obligatorio usar una lista doblemente ligada para cada caso a evaluar.
