package android.support.v4.media;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import defpackage.c4;
import defpackage.kb;
import defpackage.tk0;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class MediaMetadataCompat implements Parcelable {
    public static final Parcelable.Creator<MediaMetadataCompat> CREATOR;
    public final Bundle b;

    static {
        kb kbVar = new kb(0);
        kbVar.put("android.media.metadata.TITLE", 1);
        kbVar.put("android.media.metadata.ARTIST", 1);
        kbVar.put("android.media.metadata.DURATION", 0);
        kbVar.put("android.media.metadata.ALBUM", 1);
        kbVar.put("android.media.metadata.AUTHOR", 1);
        kbVar.put("android.media.metadata.WRITER", 1);
        kbVar.put("android.media.metadata.COMPOSER", 1);
        kbVar.put("android.media.metadata.COMPILATION", 1);
        kbVar.put("android.media.metadata.DATE", 1);
        kbVar.put("android.media.metadata.YEAR", 0);
        kbVar.put("android.media.metadata.GENRE", 1);
        kbVar.put("android.media.metadata.TRACK_NUMBER", 0);
        kbVar.put("android.media.metadata.NUM_TRACKS", 0);
        kbVar.put("android.media.metadata.DISC_NUMBER", 0);
        kbVar.put("android.media.metadata.ALBUM_ARTIST", 1);
        kbVar.put("android.media.metadata.ART", 2);
        kbVar.put("android.media.metadata.ART_URI", 1);
        kbVar.put("android.media.metadata.ALBUM_ART", 2);
        kbVar.put("android.media.metadata.ALBUM_ART_URI", 1);
        kbVar.put("android.media.metadata.USER_RATING", 3);
        kbVar.put("android.media.metadata.RATING", 3);
        kbVar.put("android.media.metadata.DISPLAY_TITLE", 1);
        kbVar.put("android.media.metadata.DISPLAY_SUBTITLE", 1);
        kbVar.put("android.media.metadata.DISPLAY_DESCRIPTION", 1);
        kbVar.put("android.media.metadata.DISPLAY_ICON", 2);
        kbVar.put("android.media.metadata.DISPLAY_ICON_URI", 1);
        kbVar.put("android.media.metadata.MEDIA_ID", 1);
        kbVar.put("android.media.metadata.BT_FOLDER_TYPE", 0);
        kbVar.put("android.media.metadata.MEDIA_URI", 1);
        kbVar.put("android.media.metadata.ADVERTISEMENT", 0);
        kbVar.put("android.media.metadata.DOWNLOAD_STATUS", 0);
        CREATOR = new c4(23);
    }

    public MediaMetadataCompat(Parcel parcel) {
        this.b = parcel.readBundle(tk0.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeBundle(this.b);
    }
}
