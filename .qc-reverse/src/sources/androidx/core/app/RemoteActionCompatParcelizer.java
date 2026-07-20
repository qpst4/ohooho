package androidx.core.app;

import android.app.PendingIntent;
import android.os.Parcel;
import android.text.TextUtils;
import androidx.core.graphics.drawable.IconCompat;
import defpackage.ue1;
import defpackage.ve1;
import defpackage.we1;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(ue1 ue1Var) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        we1 we1VarH = remoteActionCompat.a;
        boolean z = true;
        if (ue1Var.e(1)) {
            we1VarH = ue1Var.h();
        }
        remoteActionCompat.a = (IconCompat) we1VarH;
        CharSequence charSequence = remoteActionCompat.b;
        if (ue1Var.e(2)) {
            charSequence = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(((ve1) ue1Var).e);
        }
        remoteActionCompat.b = charSequence;
        CharSequence charSequence2 = remoteActionCompat.c;
        if (ue1Var.e(3)) {
            charSequence2 = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(((ve1) ue1Var).e);
        }
        remoteActionCompat.c = charSequence2;
        remoteActionCompat.d = (PendingIntent) ue1Var.g(remoteActionCompat.d, 4);
        boolean z2 = remoteActionCompat.e;
        if (ue1Var.e(5)) {
            z2 = ((ve1) ue1Var).e.readInt() != 0;
        }
        remoteActionCompat.e = z2;
        boolean z3 = remoteActionCompat.f;
        if (!ue1Var.e(6)) {
            z = z3;
        } else if (((ve1) ue1Var).e.readInt() == 0) {
            z = false;
        }
        remoteActionCompat.f = z;
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, ue1 ue1Var) {
        ue1Var.getClass();
        IconCompat iconCompat = remoteActionCompat.a;
        ue1Var.i(1);
        ue1Var.k(iconCompat);
        CharSequence charSequence = remoteActionCompat.b;
        ue1Var.i(2);
        Parcel parcel = ((ve1) ue1Var).e;
        TextUtils.writeToParcel(charSequence, parcel, 0);
        CharSequence charSequence2 = remoteActionCompat.c;
        ue1Var.i(3);
        TextUtils.writeToParcel(charSequence2, parcel, 0);
        PendingIntent pendingIntent = remoteActionCompat.d;
        ue1Var.i(4);
        parcel.writeParcelable(pendingIntent, 0);
        boolean z = remoteActionCompat.e;
        ue1Var.i(5);
        parcel.writeInt(z ? 1 : 0);
        boolean z2 = remoteActionCompat.f;
        ue1Var.i(6);
        parcel.writeInt(z2 ? 1 : 0);
    }
}
