public class DesaturateIt {

    public static void main(String [] args){
        int[][][] rgb = Java101ImageUtil.getRGBArrayFromFile();
        if (rgb == null) return;
        int[][][] gray = grayscale(rgb);
        int[][][] sepia = sepia(rgb);
        int[][][][] rgbs = {rgb, gray, sepia};
        Java101ImageUtil.showViewer(rgbs, "show all");
    }

    public static int [][][] grayscale(int [][][] rgb) {
        int[][][] result = new int[rgb.length][rgb[0].length][3];
        double rw, gw, bw, grayscale, total;
        for (int x = 0; x < rgb.length; x++) {
            for (int y = 0; y < rgb[0].length; y++) {
                total = rgb[x][y][0] + rgb[x][y][1] + rgb[x][y][2];
                if (total == 0) total = 1;
                rw = (double) rgb[x][y][0] / total;
                gw = (double) rgb[x][y][1] / total;
                bw = (double) rgb[x][y][2] / total;
                grayscale = (rw * rgb[x][y][0]) + (gw * rgb[x][y][1]) + (bw * rgb[x][y][2]);
                result[x][y][0] = (int) grayscale;
                result[x][y][1] = (int) grayscale;
                result[x][y][2] = (int) grayscale;
            }
        }
        return result;
    }

    public static int [][][] sepia(int [][][] rgb) {
        int[][][] result = new int[rgb.length][rgb[0].length][3];
        double tr, tg, tb;
        for (int x = 0; x < rgb.length; x++) {
            for (int y = 0; y < rgb[0].length; y++) {
                tr = 0.393 * rgb[x][y][0] + 0.769 * rgb[x][y][1] + 0.189 * rgb[x][y][2];
                tg = 0.349 * rgb[x][y][0] + 0.686 * rgb[x][y][1] + 0.168 * rgb[x][y][2];
                tb = 0.272 * rgb[x][y][0] + 0.534 * rgb[x][y][1] + 0.131 * rgb[x][y][2];
                if (tr > 255) result[x][y][0] = 255;   else result[x][y][0] = (int) tr;
                if (tg > 255) result[x][y][1] = 255;   else result[x][y][1] = (int) tg;
                if (tb > 255) result[x][y][2] = 255;   else result[x][y][2] = (int) tb;
            }
        }
        return result;
    }

}



