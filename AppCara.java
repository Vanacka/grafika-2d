package gyarab.grafika;

public class AppCara extends Gyarab2D {

    public boolean maluj(int idx) {
        /*for (int i = -maxXY; i < maxXY; i++) {
            namalujBod(0, i);
            namalujBod(i, 0);
        }*/
        Matrix m = Matrix.rotation3Dy( idx*Math.PI / 20);
            //System.out.println(m);
        System.out.println(idx);


            Matrix posun1 = Matrix.transposition3D(-30, -30, -30);
            Matrix otoc1 = Matrix.rotation3Dz(Math.PI/4);
            Matrix otoc2 = Matrix.rotation3Dx(Math.PI/4);
            Matrix otoc3 = Matrix.rotation3Dz(-Math.PI/4);
            Matrix otoc4 = Matrix.rotation3Dx(-Math.PI/4);
            Matrix posun2 = Matrix.transposition3D(30, 30, 30);
            Matrix megaMatice = posun2.times(otoc3).times(otoc4).times(m).times(otoc1).times(otoc2).times(posun1);
            // namaluj caru z bodu 0,0 do 100,0
            //for (int i = -maxXY; i < maxXY; i++) {
                //namalujBod(i, 0);
                //namalujBod(0, i);

            namalujCtverec(megaMatice,60, 0, 0, 0);
        return true;
    }
    public void namalujCtverec (Matrix tr, int a, int x, int y, int z) {
        for (int i = 0; i <= a-x; i++) {
            tockyMocky(tr,x + i, y, z);
            tockyMocky(tr, a, y + i, z);
            tockyMocky(tr, x, y + i, z);
            tockyMocky(tr,x + i, a, z);

            tockyMocky(tr,x , y, z + i);
            tockyMocky(tr,a , y, z + i);
            tockyMocky(tr,x , a, z + i);
            tockyMocky(tr,a , a, z + i);

            tockyMocky(tr,x + i, y, a);
            tockyMocky(tr, a, y + i, a);
            tockyMocky(tr, x, y + i, a);
            tockyMocky(tr,x + i, a, a);
        }
    }
    public void tockyMocky(Matrix tr, int x, int y, int z) {
        double[][] souradnice = {{x}, {y}, {z}, {1}};
        Matrix v = new Matrix(souradnice);
        Matrix vysledek = tr.times(v);
        namalujBod((int) vysledek.get(0, 0), (int) vysledek.get(1, 0));
    }

    public static void main(String[] args) {
        launch();
    }
}