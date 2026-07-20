package defpackage;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class jk1 extends v {
    public static final Parcelable.Creator<jk1> CREATOR = new ip0(17);
    public final int b;
    public final Account c;
    public final int d;
    public final GoogleSignInAccount e;

    public jk1(int i, Account account, int i2, GoogleSignInAccount googleSignInAccount) {
        this.b = i;
        this.c = account;
        this.d = i2;
        this.e = googleSignInAccount;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iR = tk0.R(parcel, 20293);
        tk0.V(parcel, 1, 4);
        parcel.writeInt(this.b);
        tk0.M(parcel, 2, this.c, i);
        tk0.V(parcel, 3, 4);
        parcel.writeInt(this.d);
        tk0.M(parcel, 4, this.e, i);
        tk0.U(parcel, iR);
    }
}
