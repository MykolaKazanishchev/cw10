public interface IHazardNotifier {
    void notifyHazard(String message, String containerSerialNumber);

    void notifyHazard(String message);

}
