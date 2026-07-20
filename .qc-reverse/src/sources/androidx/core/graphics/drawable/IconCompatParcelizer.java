package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Parcel;
import android.os.Parcelable;
import defpackage.ue1;
import defpackage.ve1;
import defpackage.zy;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class IconCompatParcelizer {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static IconCompat read(ue1 ue1Var) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.a = ue1Var.f(iconCompat.a, 1);
        byte[] bArr = iconCompat.c;
        if (ue1Var.e(2)) {
            Parcel parcel = ((ve1) ue1Var).e;
            int i = parcel.readInt();
            if (i < 0) {
                bArr = null;
            } else {
                byte[] bArr2 = new byte[i];
                parcel.readByteArray(bArr2);
                bArr = bArr2;
            }
        }
        iconCompat.c = bArr;
        iconCompat.d = ue1Var.g(iconCompat.d, 3);
        iconCompat.e = ue1Var.f(iconCompat.e, 4);
        iconCompat.f = ue1Var.f(iconCompat.f, 5);
        iconCompat.g = (ColorStateList) ue1Var.g(iconCompat.g, 6);
        String string = iconCompat.i;
        if (ue1Var.e(7)) {
            string = ((ve1) ue1Var).e.readString();
        }
        iconCompat.i = string;
        String string2 = iconCompat.j;
        if (ue1Var.e(8)) {
            string2 = ((ve1) ue1Var).e.readString();
        }
        iconCompat.j = string2;
        iconCompat.h = PorterDuff.Mode.valueOf(iconCompat.i);
        switch (iconCompat.a) {
            case -1:
                Parcelable parcelable = iconCompat.d;
                if (parcelable != null) {
                    iconCompat.b = parcelable;
                    return iconCompat;
                }
                zy.n("Invalid icon");
                return null;
            case 0:
            default:
                return iconCompat;
            case 1:
            case 5:
                Parcelable parcelable2 = iconCompat.d;
                if (parcelable2 != null) {
                    iconCompat.b = parcelable2;
                    return iconCompat;
                }
                byte[] bArr3 = iconCompat.c;
                iconCompat.b = bArr3;
                iconCompat.a = 3;
                iconCompat.e = 0;
                iconCompat.f = bArr3.length;
                return iconCompat;
            case 2:
            case 4:
            case 6:
                String str = new String(iconCompat.c, Charset.forName("UTF-16"));
                iconCompat.b = str;
                if (iconCompat.a == 2 && iconCompat.j == null) {
                    iconCompat.j = str.split(":", -1)[0];
                }
                return iconCompat;
            case 3:
                iconCompat.b = iconCompat.c;
                return iconCompat;
        }
    }

    public static void write(IconCompat iconCompat, ue1 ue1Var) {
        ue1Var.getClass();
        iconCompat.i = iconCompat.h.name();
        switch (iconCompat.a) {
            case -1:
                iconCompat.d = (Parcelable) iconCompat.b;
                break;
            case 1:
            case 5:
                iconCompat.d = (Parcelable) iconCompat.b;
                break;
            case 2:
                iconCompat.c = ((String) iconCompat.b).getBytes(Charset.forName("UTF-16"));
                break;
            case 3:
                iconCompat.c = (byte[]) iconCompat.b;
                break;
            case 4:
            case 6:
                iconCompat.c = iconCompat.b.toString().getBytes(Charset.forName("UTF-16"));
                break;
        }
        int i = iconCompat.a;
        if (-1 != i) {
            ue1Var.j(i, 1);
        }
        byte[] bArr = iconCompat.c;
        if (bArr != null) {
            ue1Var.i(2);
            Parcel parcel = ((ve1) ue1Var).e;
            parcel.writeInt(bArr.length);
            parcel.writeByteArray(bArr);
        }
        Parcelable parcelable = iconCompat.d;
        if (parcelable != null) {
            ue1Var.i(3);
            ((ve1) ue1Var).e.writeParcelable(parcelable, 0);
        }
        int i2 = iconCompat.e;
        if (i2 != 0) {
            ue1Var.j(i2, 4);
        }
        int i3 = iconCompat.f;
        if (i3 != 0) {
            ue1Var.j(i3, 5);
        }
        ColorStateList colorStateList = iconCompat.g;
        if (colorStateList != null) {
            ue1Var.i(6);
            ((ve1) ue1Var).e.writeParcelable(colorStateList, 0);
        }
        String str = iconCompat.i;
        if (str != null) {
            ue1Var.i(7);
            ((ve1) ue1Var).e.writeString(str);
        }
        String str2 = iconCompat.j;
        if (str2 != null) {
            ue1Var.i(8);
            ((ve1) ue1Var).e.writeString(str2);
        }
    }
}
