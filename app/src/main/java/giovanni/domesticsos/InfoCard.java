package giovanni.domesticsos;

public class InfoCard {

    private String title;

    private String infoText;

    private String photoUrl;

    private int dangerScore;

    public InfoCard(){}

    public InfoCard(String title, String infoText, String photoUrl, int dangerScore) {
        this.title = title;
        this.infoText = infoText;
        this.photoUrl = photoUrl;
        this.dangerScore = dangerScore;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInfoText() {
        return infoText;
    }

    public void setInfoText(String infoText) {
        this.infoText = infoText;
    }

    public int getDangerScore() {
        return dangerScore;
    }

    public void setDangerScore(int dangerScore) {
        this.dangerScore = dangerScore;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}
