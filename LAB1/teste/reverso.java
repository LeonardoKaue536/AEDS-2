package teste;

class CelulaDupla {
    int elemento;
    CelulaDupla prox, ant;
}

public class reverso {
    
    

}


CelulaDupla intecalarReverso(celulaDupla c1, celulaDupla c2){

    //Percorrendo até o final da celula
    CelulaDupla fim1 = c1;
    while (fim1.prox != null){
        fim1 = fim1.prox;
    }

    CelulaDupla fim2 = c2;
    while(fim2.prox != null){
        fim2 = fim2.prox;
    }

    CelulaDupla novalista = null;//pro inicio
    CelulaDupla ultima = null;//pro final


    boolean altenar = true;
    while(fim1 != null || fim2 != null){

        if(altenar && fim2 != null){
            CelulaDupla nova = new CelulaDupla();
            nova.elemento = fim1.elemento;

            if(novalista == null){
                novalista = nova;
                ultima = nova;
            }else{
                ultima.prox = nova;
                nova.ant = ultima;
                ultima = nova;
            }
            fim1 = fim1.ant;

        } else if (!alternar && fim2 != null) {
            CelulaDupla nova = new CelulaDupla();
            nova.elemento = fim2.elemento;

            if (novaLista == null) {
                novaLista = nova;
                ultima = nova;
            } else {
                ultima.prox = nova;
                nova.ant = ultima;
                ultima = nova;
            }

            fim2 = fim2.ant;
        }
        altenar = !altenar;
    }

}