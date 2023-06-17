package exception;

public class GuideNotFoundException extends ResourceNotFoundException {
    public GuideNotFoundException(Long guideId) {
        super("Guide not found, guideId: " + guideId);
    }
}
