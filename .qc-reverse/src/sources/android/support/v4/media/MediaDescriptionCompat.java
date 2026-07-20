package android.support.v4.media;

import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import defpackage.c4;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class MediaDescriptionCompat implements Parcelable {
    public static final Parcelable.Creator<MediaDescriptionCompat> CREATOR = new c4(22);
    public final String b;
    public final CharSequence c;
    public final CharSequence d;
    public final CharSequence e;
    public final Bitmap f;
    public final Uri g;
    public final Bundle h;
    public final Uri i;
    public Object j;

    public MediaDescriptionCompat(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.b = str;
        this.c = charSequence;
        this.d = charSequence2;
        this.e = charSequence3;
        this.f = bitmap;
        this.g = uri;
        this.h = bundle;
        this.i = uri2;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return ((Object) this.c) + ", " + ((Object) this.d) + ", " + ((Object) this.e);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        Object objBuild = this.j;
        if (objBuild == null) {
            MediaDescription.Builder builder = new MediaDescription.Builder();
            builder.setMediaId(this.b);
            builder.setTitle(this.c);
            builder.setSubtitle(this.d);
            builder.setDescription(this.e);
            builder.setIconBitmap(this.f);
            builder.setIconUri(this.g);
            builder.setExtras(this.h);
            builder.setMediaUri(this.i);
            objBuild = builder.build();
            this.j = objBuild;
        }
        ((MediaDescription) objBuild).writeToParcel(parcel, i);
    }
}
