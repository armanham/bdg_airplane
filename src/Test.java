import service.AdministrationService;
import service.PlaneService;

public class Test {

    public static void main(String[] args) {
        PlaneService planeService = new PlaneService();
        AdministrationService administrationService = new AdministrationService(planeService);


        planeService.create("Boeing", 1, 'B');
        planeService.create("as", 6, 'F');
        planeService.create("Smalyot", 2, 'C');
        planeService.create("Inqnatir", 1, 'D');
        planeService.create("Inqnatir", 2, 'B');

        System.out.println(planeService.deleteBy(4));

        System.out.println(planeService.getPlanes());

        administrationService.reserveASeat(1,1,'A');
        administrationService.cancelAReserve(1,1,'A');
        administrationService.cancelAReserve(1,1,'B');

    }
}
