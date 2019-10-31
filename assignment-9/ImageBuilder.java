public class ImageBuilder {

    public static void main(String[] args) {
        int[][][] image = new int[256][128][3];
        for (int x = 0; x < image.length; x++) {
            for (int y = 0; y < image[0].length; y++) {
                image[x][y][0] = 255;
                image[x][y][1] = 255;
            }
        }
        Java101ImageUtil.showViewer(image, "Solid Yellow 256x128");
    }

}
