package com.example.practica_2;

public class ListaAsientos
{
    public Nodo inicio;

    ListaAsientos(int lugares)
    {
        inicio = null;
        for (int i = 1; i <= lugares ; i++) {
            lista_in(i);
        }
    }

    public void lista_in(int lugar)
    {
        Nodo temp = new Nodo(lugar);
        Nodo aux, atras;

        if(inicio == null)
            inicio = temp;
        else
        {
            if(temp.no_lugar <= inicio.no_lugar)
            {
                temp.siguiente = inicio;
                inicio = temp;
            }
            else
            {
                aux = atras = inicio;
                while(aux != null && temp.no_lugar > aux.no_lugar)
                {
                    atras = aux;
                    aux = aux.siguiente;
                }
                atras.siguiente = temp;
                temp.siguiente = aux;
            }
        }
    }

    public void modifica_dis(int lugar)
    {
        Nodo temp = new Nodo(lugar);
        Nodo aux;

        if(temp.no_lugar == inicio.no_lugar)
            inicio.disponible = false;
        else
        {
            aux = inicio;
            while (aux != null && temp.no_lugar > aux.no_lugar)
                aux = aux.siguiente;

            if (aux != null)
                aux.disponible = false;
        }
    }

    public Nodo busca(int lugar)
    {
        Nodo temp = new Nodo(lugar);
        Nodo aux;

        if(temp.no_lugar == inicio.no_lugar)
            return inicio;
        else
        {
            aux = inicio;
            while (aux != null && temp.no_lugar > aux.no_lugar)
                aux = aux.siguiente;

            return aux;
        }
    }
}

class Nodo
{
    public Nodo siguiente;
    public int no_lugar;
    public boolean disponible;
    public int precio;

    Nodo(int lugar)
    {
        siguiente = null;
        disponible = true;
        no_lugar = lugar;
         if (no_lugar <= 8)
             precio = 10000;
         else if (no_lugar <= 16)
             precio = 8000;
         else
             precio = 5000;
    }
}
