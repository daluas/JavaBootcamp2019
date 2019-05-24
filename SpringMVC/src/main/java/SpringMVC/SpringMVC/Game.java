package SpringMVC.SpringMVC;

import java.util.Date;

 class Game {
    private String title;
    private Date release_date;
    private Double rating;
    private Integer price;


     @Override
     public String toString() {
         return "Game{" +
                 "title='" + title + '\'' +
                 ", release_date=" + release_date +
                 ", rating=" + rating +
                 ", price=" + price +
                 '}';
     }

     public Game(String title, Date release_date, Double rating, Integer price) {
        this.title = title;
        this.release_date = release_date;
        this.rating = rating;
        this.price = price;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getRelease_date() {
        return release_date;
    }

    public void setRelease_date(Date release_date) {
        this.release_date = release_date;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
