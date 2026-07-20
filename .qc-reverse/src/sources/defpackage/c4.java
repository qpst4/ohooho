package defpackage;

import android.content.Intent;
import android.content.IntentSender;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.media.MediaDescription;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.support.v4.media.MediaBrowserCompat$MediaItem;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat$QueueItem;
import android.support.v4.media.session.MediaSessionCompat$ResultReceiverWrapper;
import android.support.v4.media.session.MediaSessionCompat$Token;
import android.text.TextUtils;
import defpackage.c4;
import java.util.ArrayList;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class c4 implements Parcelable.Creator {
    public final /* synthetic */ int a;

    public /* synthetic */ c4(int i) {
        this.a = i;
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(final Parcel parcel) {
        boolean z;
        Integer num;
        boolean z2;
        Integer num2;
        fq fqVar;
        mq mqVar;
        boolean z3;
        Integer num3;
        boolean z4;
        Integer num4;
        boolean z5;
        Integer num5;
        int i;
        boolean z6;
        Integer num6;
        boolean z7;
        Integer num7;
        boolean z8;
        Integer num8;
        boolean z9;
        Integer num9;
        boolean z10;
        boolean z11;
        Integer num10;
        Integer num11;
        Uri uri;
        boolean z12;
        Integer num12;
        boolean z13;
        Integer num13;
        boolean z14;
        Integer num14;
        int i2;
        boolean z15;
        Integer num15;
        boolean z16;
        Integer numValueOf;
        CharSequence charSequence;
        lq lqVar;
        Uri mediaUri;
        Bundle bundle;
        boolean z17 = true;
        switch (this.a) {
            case 0:
                parcel.getClass();
                return new d4(parcel.readInt() == 0 ? null : (Intent) Intent.CREATOR.createFromParcel(parcel), parcel.readInt());
            case 1:
                w9 w9Var = new w9(parcel);
                w9Var.b = parcel.readByte() != 0;
                return w9Var;
            case 2:
                return new qb(parcel);
            case 3:
                return new md(parcel);
            case 4:
                return new nd(parcel);
            case 5:
                zd zdVar = new zd();
                zdVar.j = 255;
                zdVar.l = -2;
                zdVar.m = -2;
                zdVar.n = -2;
                zdVar.u = Boolean.TRUE;
                zdVar.b = parcel.readInt();
                zdVar.c = (Integer) parcel.readSerializable();
                zdVar.d = (Integer) parcel.readSerializable();
                zdVar.e = (Integer) parcel.readSerializable();
                zdVar.f = (Integer) parcel.readSerializable();
                zdVar.g = (Integer) parcel.readSerializable();
                zdVar.h = (Integer) parcel.readSerializable();
                zdVar.i = (Integer) parcel.readSerializable();
                zdVar.j = parcel.readInt();
                zdVar.k = parcel.readString();
                zdVar.l = parcel.readInt();
                zdVar.m = parcel.readInt();
                zdVar.n = parcel.readInt();
                zdVar.p = parcel.readString();
                zdVar.q = parcel.readString();
                zdVar.r = parcel.readInt();
                zdVar.t = (Integer) parcel.readSerializable();
                zdVar.v = (Integer) parcel.readSerializable();
                zdVar.w = (Integer) parcel.readSerializable();
                zdVar.x = (Integer) parcel.readSerializable();
                zdVar.y = (Integer) parcel.readSerializable();
                zdVar.z = (Integer) parcel.readSerializable();
                zdVar.A = (Integer) parcel.readSerializable();
                zdVar.D = (Integer) parcel.readSerializable();
                zdVar.B = (Integer) parcel.readSerializable();
                zdVar.C = (Integer) parcel.readSerializable();
                zdVar.u = (Boolean) parcel.readSerializable();
                zdVar.o = (Locale) parcel.readSerializable();
                zdVar.E = (Boolean) parcel.readSerializable();
                return zdVar;
            case 6:
                return new fi((yl0) parcel.readParcelable(yl0.class.getClassLoader()), (yl0) parcel.readParcelable(yl0.class.getClassLoader()), (pr) parcel.readParcelable(pr.class.getClassLoader()), (yl0) parcel.readParcelable(yl0.class.getClassLoader()), parcel.readInt());
            case 7:
                kj kjVar = new kj();
                kjVar.b = parcel.readInt();
                kjVar.c = parcel.readByte() != 0;
                if ((parcel.readByte() != 0 ? fp1.z(parcel) : null) == null) {
                    if ((parcel.readByte() != 0 ? fp1.z(parcel) : null) == null) {
                        kjVar.d = (rj) fp1.z(parcel);
                        kjVar.e = (zr) fp1.z(parcel);
                        kjVar.l = parcel.readInt();
                        kjVar.m = parcel.readByte() != 0;
                        kjVar.f = parcel.readByte() != 0;
                        kjVar.g = parcel.readByte() != 0;
                        kjVar.h = parcel.readByte() != 0;
                        kjVar.i = parcel.readString();
                        kjVar.j = parcel.readString();
                        kjVar.k = parcel.readString();
                        return kjVar;
                    }
                    s1.d();
                } else {
                    s1.d();
                }
                return null;
            case 8:
                return new rj();
            case 9:
                parcel.getClass();
                Uri uri2 = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
                Uri uri3 = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
                Exception exc = (Exception) parcel.readSerializable();
                float[] fArrCreateFloatArray = parcel.createFloatArray();
                fArrCreateFloatArray.getClass();
                return new vp(uri2, uri3, exc, fArrCreateFloatArray, (Rect) parcel.readParcelable(Rect.class.getClassLoader()), (Rect) parcel.readParcelable(Rect.class.getClassLoader()), parcel.readInt(), parcel.readInt());
            case 10:
                parcel.getClass();
                if (parcel.readInt() != 0) {
                    z = true;
                } else {
                    z = true;
                    z17 = false;
                }
                if (parcel.readInt() != 0) {
                    num = null;
                    z2 = z;
                } else {
                    num = null;
                    z2 = false;
                }
                eq eqVarValueOf = eq.valueOf(parcel.readString());
                dq dqVarValueOf = dq.valueOf(parcel.readString());
                Integer num16 = num;
                float f = parcel.readFloat();
                float f2 = parcel.readFloat();
                float f3 = parcel.readFloat();
                fq fqVarValueOf = fq.valueOf(parcel.readString());
                mq mqVarValueOf = mq.valueOf(parcel.readString());
                if (parcel.readInt() != 0) {
                    num2 = num16;
                    fqVar = fqVarValueOf;
                    mqVar = mqVarValueOf;
                    z3 = z;
                } else {
                    num2 = num16;
                    fqVar = fqVarValueOf;
                    mqVar = mqVarValueOf;
                    z3 = false;
                }
                if (parcel.readInt() != 0) {
                    num3 = num2;
                    z4 = z;
                } else {
                    num3 = num2;
                    z4 = false;
                }
                if (parcel.readInt() != 0) {
                    num4 = num3;
                    z5 = z;
                } else {
                    num4 = num3;
                    z5 = false;
                }
                int i3 = parcel.readInt();
                if (parcel.readInt() != 0) {
                    num5 = num4;
                    i = i3;
                    z6 = z;
                } else {
                    num5 = num4;
                    i = i3;
                    z6 = false;
                }
                if (parcel.readInt() != 0) {
                    num6 = num5;
                    z7 = z;
                } else {
                    num6 = num5;
                    z7 = false;
                }
                if (parcel.readInt() != 0) {
                    num7 = num6;
                    z8 = z;
                } else {
                    num7 = num6;
                    z8 = false;
                }
                if (parcel.readInt() != 0) {
                    num8 = num7;
                    z9 = z;
                } else {
                    num8 = num7;
                    z9 = false;
                }
                int i4 = parcel.readInt();
                Integer num17 = num8;
                float f4 = parcel.readFloat();
                if (parcel.readInt() != 0) {
                    num9 = num17;
                    z10 = z;
                } else {
                    num9 = num17;
                    z10 = false;
                }
                int i5 = parcel.readInt();
                Integer num18 = num9;
                int i6 = parcel.readInt();
                float f5 = parcel.readFloat();
                int i7 = parcel.readInt();
                float f6 = parcel.readFloat();
                float f7 = parcel.readFloat();
                float f8 = parcel.readFloat();
                int i8 = parcel.readInt();
                int i9 = parcel.readInt();
                float f9 = parcel.readFloat();
                int i10 = parcel.readInt();
                int i11 = parcel.readInt();
                int i12 = parcel.readInt();
                int i13 = parcel.readInt();
                int i14 = parcel.readInt();
                int i15 = parcel.readInt();
                int i16 = parcel.readInt();
                int i17 = parcel.readInt();
                Parcelable.Creator creator = TextUtils.CHAR_SEQUENCE_CREATOR;
                CharSequence charSequence2 = (CharSequence) creator.createFromParcel(parcel);
                int i18 = parcel.readInt();
                Integer numValueOf2 = parcel.readInt() == 0 ? num18 : Integer.valueOf(parcel.readInt());
                Uri uri4 = (Uri) parcel.readParcelable(cq.class.getClassLoader());
                Bitmap.CompressFormat compressFormatValueOf = Bitmap.CompressFormat.valueOf(parcel.readString());
                int i19 = parcel.readInt();
                int i20 = parcel.readInt();
                boolean z18 = true;
                int i21 = parcel.readInt();
                lq lqVarValueOf = lq.valueOf(parcel.readString());
                if (parcel.readInt() != 0) {
                    z11 = true;
                } else {
                    z11 = true;
                    z18 = false;
                }
                Rect rect = (Rect) parcel.readParcelable(cq.class.getClassLoader());
                boolean z19 = z11;
                int i22 = parcel.readInt();
                if (parcel.readInt() != 0) {
                    num10 = num18;
                    num11 = numValueOf2;
                    uri = uri4;
                    z12 = z19;
                } else {
                    num10 = num18;
                    num11 = numValueOf2;
                    uri = uri4;
                    z12 = false;
                }
                if (parcel.readInt() != 0) {
                    num12 = num10;
                    z13 = z19;
                } else {
                    num12 = num10;
                    z13 = false;
                }
                if (parcel.readInt() != 0) {
                    num13 = num12;
                    z14 = z19;
                } else {
                    num13 = num12;
                    z14 = false;
                }
                int i23 = parcel.readInt();
                if (parcel.readInt() != 0) {
                    num14 = num13;
                    i2 = i23;
                    z15 = z19;
                } else {
                    num14 = num13;
                    i2 = i23;
                    z15 = false;
                }
                if (parcel.readInt() != 0) {
                    num15 = num14;
                    z16 = z19;
                } else {
                    num15 = num14;
                    z16 = false;
                }
                CharSequence charSequence3 = (CharSequence) creator.createFromParcel(parcel);
                int i24 = parcel.readInt();
                boolean z20 = parcel.readInt() != 0 ? z19 : false;
                boolean z21 = parcel.readInt() != 0 ? z19 : false;
                String string = parcel.readString();
                ArrayList<String> arrayListCreateStringArrayList = parcel.createStringArrayList();
                float f10 = parcel.readFloat();
                int i25 = parcel.readInt();
                String string2 = parcel.readString();
                int i26 = parcel.readInt();
                Integer numValueOf3 = parcel.readInt() == 0 ? num15 : Integer.valueOf(parcel.readInt());
                Integer numValueOf4 = parcel.readInt() == 0 ? num15 : Integer.valueOf(parcel.readInt());
                Integer numValueOf5 = parcel.readInt() == 0 ? num15 : Integer.valueOf(parcel.readInt());
                if (parcel.readInt() == 0) {
                    numValueOf = num15;
                    lqVar = lqVarValueOf;
                    charSequence = charSequence3;
                } else {
                    numValueOf = Integer.valueOf(parcel.readInt());
                    charSequence = charSequence3;
                    lqVar = lqVarValueOf;
                }
                return new cq(z17, z2, eqVarValueOf, dqVarValueOf, f, f2, f3, fqVar, mqVar, z3, z4, z5, i, z6, z7, z8, z9, i4, f4, z10, i5, i6, f5, i7, f6, f7, f8, i8, i9, f9, i10, i11, i12, i13, i14, i15, i16, i17, charSequence2, i18, num11, uri, compressFormatValueOf, i19, i20, i21, lqVar, z18, rect, i22, z12, z13, z14, i2, z15, z16, charSequence, i24, z20, z21, string, arrayListCreateStringArrayList, f10, i25, string2, i26, numValueOf3, numValueOf4, numValueOf5, numValueOf);
            case 11:
                return new pr(parcel.readLong());
            case 12:
                zr zrVar = new zr();
                zrVar.b = l11.x(2)[parcel.readInt()];
                zrVar.c = parcel.readString();
                return zrVar;
            case 13:
                return new jx(parcel);
            case 14:
                v30 v30Var = new v30();
                v30Var.b = parcel.readString();
                v30Var.c = parcel.readInt();
                return v30Var;
            case 15:
                z30 z30Var = new z30();
                z30Var.f = null;
                z30Var.g = new ArrayList();
                z30Var.h = new ArrayList();
                z30Var.b = parcel.createStringArrayList();
                z30Var.c = parcel.createStringArrayList();
                z30Var.d = (md[]) parcel.createTypedArray(md.CREATOR);
                z30Var.e = parcel.readInt();
                z30Var.f = parcel.readString();
                z30Var.g = parcel.createStringArrayList();
                z30Var.h = parcel.createTypedArrayList(nd.CREATOR);
                z30Var.i = parcel.createTypedArrayList(v30.CREATOR);
                return z30Var;
            case 16:
                return new e40(parcel);
            case 17:
                parcel.getClass();
                Parcelable parcelable = parcel.readParcelable(IntentSender.class.getClassLoader());
                parcelable.getClass();
                return new cc0((IntentSender) parcelable, (Intent) parcel.readParcelable(Intent.class.getClassLoader()), parcel.readInt(), parcel.readInt());
            case 18:
                pg0 pg0Var = new pg0();
                pg0Var.b = parcel.readInt();
                pg0Var.c = parcel.readInt();
                pg0Var.d = parcel.readInt() == 1;
                return pg0Var;
            case 19:
                return new sh0(parcel);
            case 20:
                bk0 bk0Var = new bk0(parcel);
                bk0Var.b = ((Integer) parcel.readValue(bk0.class.getClassLoader())).intValue();
                return bk0Var;
            case 21:
                return new Parcelable(parcel) { // from class: android.support.v4.media.MediaBrowserCompat$MediaItem
                    public static final Parcelable.Creator<MediaBrowserCompat$MediaItem> CREATOR = new c4(21);
                    public final int b;
                    public final MediaDescriptionCompat c;

                    {
                        this.b = parcel.readInt();
                        this.c = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
                    }

                    @Override // android.os.Parcelable
                    public final int describeContents() {
                        return 0;
                    }

                    public final String toString() {
                        return "MediaItem{mFlags=" + this.b + ", mDescription=" + this.c + '}';
                    }

                    @Override // android.os.Parcelable
                    public final void writeToParcel(Parcel parcel2, int i27) {
                        parcel2.writeInt(this.b);
                        this.c.writeToParcel(parcel2, i27);
                    }
                };
            case 22:
                Object objCreateFromParcel = MediaDescription.CREATOR.createFromParcel(parcel);
                if (objCreateFromParcel == null) {
                    return null;
                }
                MediaDescription mediaDescription = (MediaDescription) objCreateFromParcel;
                String mediaId = mediaDescription.getMediaId();
                CharSequence title = mediaDescription.getTitle();
                CharSequence subtitle = mediaDescription.getSubtitle();
                CharSequence description = mediaDescription.getDescription();
                Bitmap iconBitmap = mediaDescription.getIconBitmap();
                Uri iconUri = mediaDescription.getIconUri();
                Bundle extras = mediaDescription.getExtras();
                if (extras != null) {
                    extras.setClassLoader(tk0.class.getClassLoader());
                    mediaUri = (Uri) extras.getParcelable("android.support.v4.media.description.MEDIA_URI");
                } else {
                    mediaUri = null;
                }
                if (mediaUri == null) {
                    bundle = extras;
                } else if (extras.containsKey("android.support.v4.media.description.NULL_BUNDLE_FLAG") && extras.size() == 2) {
                    bundle = null;
                } else {
                    extras.remove("android.support.v4.media.description.MEDIA_URI");
                    extras.remove("android.support.v4.media.description.NULL_BUNDLE_FLAG");
                    bundle = extras;
                }
                if (mediaUri == null) {
                    mediaUri = mediaDescription.getMediaUri();
                }
                MediaDescriptionCompat mediaDescriptionCompat = new MediaDescriptionCompat(mediaId, title, subtitle, description, iconBitmap, iconUri, bundle, mediaUri);
                mediaDescriptionCompat.j = objCreateFromParcel;
                return mediaDescriptionCompat;
            case 23:
                return new MediaMetadataCompat(parcel);
            case 24:
                return new Parcelable(parcel) { // from class: android.support.v4.media.session.MediaSessionCompat$QueueItem
                    public static final Parcelable.Creator<MediaSessionCompat$QueueItem> CREATOR = new c4(24);
                    public final MediaDescriptionCompat b;
                    public final long c;

                    {
                        this.b = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
                        this.c = parcel.readLong();
                    }

                    @Override // android.os.Parcelable
                    public final int describeContents() {
                        return 0;
                    }

                    public final String toString() {
                        return "MediaSession.QueueItem {Description=" + this.b + ", Id=" + this.c + " }";
                    }

                    @Override // android.os.Parcelable
                    public final void writeToParcel(Parcel parcel2, int i27) {
                        this.b.writeToParcel(parcel2, i27);
                        parcel2.writeLong(this.c);
                    }
                };
            case 25:
                MediaSessionCompat$ResultReceiverWrapper mediaSessionCompat$ResultReceiverWrapper = new MediaSessionCompat$ResultReceiverWrapper();
                mediaSessionCompat$ResultReceiverWrapper.b = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcel);
                return mediaSessionCompat$ResultReceiverWrapper;
            case 26:
                final Parcelable parcelable2 = parcel.readParcelable(null);
                return new Parcelable(parcelable2) { // from class: android.support.v4.media.session.MediaSessionCompat$Token
                    public static final Parcelable.Creator<MediaSessionCompat$Token> CREATOR = new c4(26);
                    public final Object b;

                    {
                        this.b = parcelable2;
                    }

                    @Override // android.os.Parcelable
                    public final int describeContents() {
                        return 0;
                    }

                    public final boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (!(obj instanceof MediaSessionCompat$Token)) {
                            return false;
                        }
                        Object obj2 = ((MediaSessionCompat$Token) obj).b;
                        Object obj3 = this.b;
                        if (obj3 == null) {
                            return obj2 == null;
                        }
                        if (obj2 == null) {
                            return false;
                        }
                        return obj3.equals(obj2);
                    }

                    public final int hashCode() {
                        Object obj = this.b;
                        if (obj == null) {
                            return 0;
                        }
                        return obj.hashCode();
                    }

                    @Override // android.os.Parcelable
                    public final void writeToParcel(Parcel parcel2, int i27) {
                        parcel2.writeParcelable((Parcelable) this.b, i27);
                    }
                };
            case 27:
                return yl0.a(parcel.readInt(), parcel.readInt());
            case 28:
                return new em0(parcel);
            default:
                nm0 nm0Var = new nm0(parcel);
                nm0Var.b = parcel.readInt();
                return nm0Var;
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        switch (this.a) {
            case 0:
                return new d4[i];
            case 1:
                return new w9[i];
            case 2:
                return new qb[i];
            case 3:
                return new md[i];
            case 4:
                return new nd[i];
            case 5:
                return new zd[i];
            case 6:
                return new fi[i];
            case 7:
                return new kj[i];
            case 8:
                return new rj[i];
            case 9:
                return new vp[i];
            case 10:
                return new cq[i];
            case 11:
                return new pr[i];
            case 12:
                return new zr[i];
            case 13:
                return new jx[i];
            case 14:
                return new v30[i];
            case 15:
                return new z30[i];
            case 16:
                return new e40[i];
            case 17:
                return new cc0[i];
            case 18:
                return new pg0[i];
            case 19:
                return new sh0[i];
            case 20:
                return new bk0[i];
            case 21:
                return new MediaBrowserCompat$MediaItem[i];
            case 22:
                return new MediaDescriptionCompat[i];
            case 23:
                return new MediaMetadataCompat[i];
            case 24:
                return new MediaSessionCompat$QueueItem[i];
            case 25:
                return new MediaSessionCompat$ResultReceiverWrapper[i];
            case 26:
                return new MediaSessionCompat$Token[i];
            case 27:
                return new yl0[i];
            case 28:
                return new em0[i];
            default:
                return new nm0[i];
        }
    }
}
