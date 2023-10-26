import java.text.DecimalFormat;
import java.util.Scanner;

public class vendasTrimestreFiat {

    static Scanner entrada = new Scanner(System.in);
    static DecimalFormat moeda = new DecimalFormat("#,## 0.00");

    public static void main(String[] args) {

        System.out.println("-----FIAT-----");

        String[] arrayCarro = new String[]{"Uno","Palio","Siena","Bravo","Strada","Idea"};
        double[] arrayPreco = new double[]{25370,26490,30000,56800,36200,43890};

        int matrizVendasCarrosTrimestre[][] = vendasCarrosTrimestre(arrayCarro);

        calculaPorCarroQuantTrimestre(matrizVendasCarrosTrimestre);

        relatorioGerencial(matrizVendasCarrosTrimestre , arrayPreco, arrayCarro);

    }// Main

    public static int[][] vendasCarrosTrimestre(String arrayCarro[]) {

        int matrizVendasCarrosTrimestre[][] = new int[3][6];

        for(int i = 0; i < 3; i++) {

            System.out.println("Vendas trimestre " + (i+1));

            for(int j = 0; j < 6; j++) {

                System.out.print("Carro " + arrayCarro[j] + ": ");
                matrizVendasCarrosTrimestre[i][j] = entrada.nextInt();

            }// Coluna

            System.out.println();

        }// Linha

        return matrizVendasCarrosTrimestre;

    }// Função Vendas carros trimestre

    public static int[] calculaPorCarroQuantTrimestre(int matrizVendasCarrosTrimestre[][]) {

        int vetorQuantPorCarro[] = new int[6];

        for(int j = 0; j < 6; j++) {

            for(int i = 0; i < 3; i++) {

                vetorQuantPorCarro[j] += matrizVendasCarrosTrimestre[i][j];

            }// Linhas

        }// Colunas

        return vetorQuantPorCarro;

    }// Função calcula por carro quant trimestre

    public static double[] calculaValorTotal(double arrayPreco[], int vetorQuantPorCarro[]) {

        double vetorValorTotalVendasCadaCarro[] = new double[6];

        for(int i = 0; i < vetorValorTotalVendasCadaCarro.length; i++) {

            vetorValorTotalVendasCadaCarro[i] = (double) vetorQuantPorCarro[i] * arrayPreco[i];

        }// For

        return vetorValorTotalVendasCadaCarro;

    }// Função calcula valor total

    public static int[] calculaTotalVendasTrimestre(int matrizVendasCarrosTrimestre[][]) {

        int vetorSomaTotalTrimestre[] = new int[3];

        for(int i = 0; i < 3; i++) {

            for(int j = 0; j < 6; j++) {

                vetorSomaTotalTrimestre[i] += matrizVendasCarrosTrimestre[i][j];

            }// Coluna

        }// Linha

        return vetorSomaTotalTrimestre;

    }// Função calcula total vendas trimestre

    public static void relatorioGerencial(int matrizVendasCarrosTrimestre[][], double arrayPreco[], String arrayCarro[]) {

        int vetorQuantPorCarro[] = calculaPorCarroQuantTrimestre(matrizVendasCarrosTrimestre);

        double vetorValorTotalVendasCadaCarro[] = calculaValorTotal(arrayPreco,vetorQuantPorCarro);

        int vetorSomaTotalTrimestre[] = calculaTotalVendasTrimestre(matrizVendasCarrosTrimestre);

        double valorTotalGeral = 0;

        for(int i = 0; i < 6; i++) {

            System.out.println("Carro " + arrayCarro[i] + "\t"
                    + "Quantidade geral " + vetorQuantPorCarro[i] + "\t"
                    + "Total: " + vetorValorTotalVendasCadaCarro[i]);

            valorTotalGeral += vetorValorTotalVendasCadaCarro[i];

        }// For

        System.out.println();

        System.out.println("Total Geral de vendas 2014: " + valorTotalGeral);

        ordenarVendas(vetorValorTotalVendasCadaCarro,arrayCarro);

    }// Procedimento relatório gerencial


    public static void ordenarVendas(double vetorValorTotalVendasCadaCarro[], String arrayCarro[]) {

        String auxCarro = "";
        double aux = 0;

        for(int i = 0; i < 6; i++) {

            for(int j = 0; j < 5; j++) {

                if(vetorValorTotalVendasCadaCarro[j] < vetorValorTotalVendasCadaCarro[j+1]) {


                    aux = vetorValorTotalVendasCadaCarro[j];
                    vetorValorTotalVendasCadaCarro[j] = vetorValorTotalVendasCadaCarro[j+1];
                    vetorValorTotalVendasCadaCarro[j+1] = aux;

                    auxCarro = arrayCarro[j];
                    arrayCarro[j] = arrayCarro[j+1];
                    arrayCarro[j+1] = auxCarro;



                }// If ordena

            }// For compara

        }// For tamanho vetor

        System.out.println();
        System.out.println("Rank de carros");
        System.out.println();

        for(int y = 0; y < arrayCarro.length; y++) {

            System.out.println(arrayCarro[y] + ": " + moeda.format(vetorValorTotalVendasCadaCarro[y]));

        }// For exibe ordenação

    }// Procedimento ordenar vendas

}// Class
