package defpackage;

import android.accounts.Account;
import android.content.Context;
import android.os.Handler;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class uj1 extends kj1 implements y60, z60 {
    public static final gj1 j = wj1.a;
    public final Context c;
    public final Handler d;
    public final gj1 e;
    public final Set f;
    public final a9 g;
    public q01 h;
    public o90 i;

    public uj1(Context context, kk1 kk1Var, a9 a9Var) {
        super(0);
        attachInterface(this, "com.google.android.gms.signin.internal.ISignInCallbacks");
        this.c = context;
        this.d = kk1Var;
        this.g = a9Var;
        this.f = (Set) a9Var.a;
        this.e = j;
    }

    @Override // defpackage.y60
    public final void a(int i) {
        o90 o90Var = this.i;
        mj1 mj1Var = (mj1) ((a70) o90Var.g).j.get((w7) o90Var.d);
        if (mj1Var != null) {
            if (mj1Var.j) {
                mj1Var.p(new xm(17));
            } else {
                mj1Var.a(i);
            }
        }
    }

    @Override // defpackage.z60
    public final void b(xm xmVar) {
        this.i.a(xmVar);
    }

    @Override // defpackage.y60
    public final void c() {
        GoogleSignInAccount googleSignInAccountA;
        q01 q01Var = this.h;
        q01Var.getClass();
        boolean z = false;
        try {
            q01Var.z.getClass();
            Account account = new Account("<<default account>>", "com.google");
            if ("<<default account>>".equals(account.name)) {
                Context context = q01Var.c;
                ReentrantLock reentrantLock = r21.c;
                xy0.d(context);
                ReentrantLock reentrantLock2 = r21.c;
                reentrantLock2.lock();
                try {
                    if (r21.d == null) {
                        r21.d = new r21(context.getApplicationContext());
                    }
                    r21 r21Var = r21.d;
                    reentrantLock2.unlock();
                    String strA = r21Var.a("defaultGoogleSignInAccount");
                    if (!TextUtils.isEmpty(strA)) {
                        String strA2 = r21Var.a("googleSignInAccount:" + strA);
                        if (strA2 != null) {
                            try {
                                googleSignInAccountA = GoogleSignInAccount.a(strA2);
                            } catch (JSONException unused) {
                                googleSignInAccountA = null;
                            }
                        }
                    }
                    googleSignInAccountA = null;
                } catch (Throwable th) {
                    reentrantLock2.unlock();
                    throw th;
                }
            } else {
                googleSignInAccountA = null;
            }
            Integer num = q01Var.B;
            xy0.d(num);
            jk1 jk1Var = new jk1(2, account, num.intValue(), googleSignInAccountA);
            yj1 yj1Var = (yj1) q01Var.p();
            Parcel parcelObtain = Parcel.obtain();
            parcelObtain.writeInterfaceToken(yj1Var.d);
            int i = qj1.a;
            parcelObtain.writeInt(1);
            int iR = tk0.R(parcelObtain, 20293);
            tk0.V(parcelObtain, 1, 4);
            parcelObtain.writeInt(1);
            tk0.M(parcelObtain, 2, jk1Var, 0);
            tk0.U(parcelObtain, iR);
            parcelObtain.writeStrongBinder(this);
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                yj1Var.c.transact(12, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                parcelObtain.recycle();
                parcelObtain2.recycle();
            } catch (Throwable th2) {
                parcelObtain.recycle();
                parcelObtain2.recycle();
                throw th2;
            }
        } catch (RemoteException e) {
            Log.w("SignInClientImpl", "Remote service probably died when signIn is called");
            try {
                this.d.post(new vn1(this, new fk1(1, new xm(8, null), null), 13, z));
            } catch (RemoteException unused2) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", e);
            }
        }
    }
}
