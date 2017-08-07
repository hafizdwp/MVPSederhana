package app.mvpsederhana.model;

/**
 * Created by Asus on 8/7/2017.
 */

public interface ApiCallback {
    //saya baru sekilas baca artikel rxjava yang dishare sama kang savarudin di slack channel android
    //jadi ini pake callback sendiri dulu, belum terlalu paham rxjava
    void onBerhasil(String body);
    void onGagal(Throwable t);
}
