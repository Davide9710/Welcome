package exception.notfound;

/**
 * Exception thrown when no guide with guideId id is found
 */
public class GuideNotFoundException extends ResourceNotFoundException {
    public GuideNotFoundException(Long guideId) {
        super("Guide not found, guideId: " + guideId);
    }
}
