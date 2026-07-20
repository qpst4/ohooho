package defpackage;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.ParcelableVolumeInfo;
import android.support.v4.media.session.PlaybackStateCompat;
import androidx.versionedparcelable.ParcelImpl;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ip0 implements Parcelable.Creator {
    public final /* synthetic */ int a;

    public /* synthetic */ ip0(int i) {
        this.a = i;
    }

    public static void a(p60 p60Var, Parcel parcel, int i) {
        int iR = tk0.R(parcel, 20293);
        int i2 = p60Var.b;
        tk0.V(parcel, 1, 4);
        parcel.writeInt(i2);
        int i3 = p60Var.c;
        tk0.V(parcel, 2, 4);
        parcel.writeInt(i3);
        int i4 = p60Var.d;
        tk0.V(parcel, 3, 4);
        parcel.writeInt(i4);
        tk0.N(parcel, 4, p60Var.e);
        IBinder iBinder = p60Var.f;
        if (iBinder != null) {
            int iR2 = tk0.R(parcel, 5);
            parcel.writeStrongBinder(iBinder);
            tk0.U(parcel, iR2);
        }
        tk0.O(parcel, 6, p60Var.g, i);
        Bundle bundle = p60Var.h;
        if (bundle != null) {
            int iR3 = tk0.R(parcel, 7);
            parcel.writeBundle(bundle);
            tk0.U(parcel, iR3);
        }
        tk0.M(parcel, 8, p60Var.i, i);
        tk0.O(parcel, 10, p60Var.j, i);
        tk0.O(parcel, 11, p60Var.k, i);
        boolean z = p60Var.l;
        tk0.V(parcel, 12, 4);
        parcel.writeInt(z ? 1 : 0);
        int i5 = p60Var.m;
        tk0.V(parcel, 13, 4);
        parcel.writeInt(i5);
        boolean z2 = p60Var.n;
        tk0.V(parcel, 14, 4);
        parcel.writeInt(z2 ? 1 : 0);
        tk0.N(parcel, 15, p60Var.o);
        tk0.U(parcel, iR);
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        na0 na0Var = null;
        String strL = null;
        PendingIntent pendingIntent = null;
        String strL2 = null;
        String strL3 = null;
        Account account = null;
        xm xmVar = null;
        Intent intent = null;
        int iJ = 0;
        switch (this.a) {
            case 0:
                return new ParcelImpl(parcel);
            case 1:
                ParcelableVolumeInfo parcelableVolumeInfo = new ParcelableVolumeInfo();
                parcelableVolumeInfo.b = parcel.readInt();
                parcelableVolumeInfo.d = parcel.readInt();
                parcelableVolumeInfo.e = parcel.readInt();
                parcelableVolumeInfo.f = parcel.readInt();
                parcelableVolumeInfo.c = parcel.readInt();
                return parcelableVolumeInfo;
            case 2:
                return new PlaybackStateCompat(parcel);
            case 3:
                return new yp0(parcel);
            case 4:
                return new hq0(parcel);
            case 5:
                return new RatingCompat(parcel.readInt(), parcel.readFloat());
            case 6:
                lw0 lw0Var = new lw0();
                IBinder strongBinder = parcel.readStrongBinder();
                int i = kw0.c;
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface(na0.a);
                    if (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof na0)) {
                        ma0 ma0Var = new ma0();
                        ma0Var.b = strongBinder;
                        na0Var = ma0Var;
                    } else {
                        na0Var = (na0) iInterfaceQueryLocalInterface;
                    }
                }
                lw0Var.b = na0Var;
                return lw0Var;
            case 7:
                return new uy0(parcel);
            case 8:
                i21 i21Var = new i21();
                i21Var.b = parcel.readInt();
                i21Var.c = parcel.readInt();
                i21Var.e = parcel.readInt() == 1;
                int i2 = parcel.readInt();
                if (i2 > 0) {
                    int[] iArr = new int[i2];
                    i21Var.d = iArr;
                    parcel.readIntArray(iArr);
                }
                return i21Var;
            case 9:
                j21 j21Var = new j21();
                j21Var.b = parcel.readInt();
                j21Var.c = parcel.readInt();
                int i3 = parcel.readInt();
                j21Var.d = i3;
                if (i3 > 0) {
                    int[] iArr2 = new int[i3];
                    j21Var.e = iArr2;
                    parcel.readIntArray(iArr2);
                }
                int i4 = parcel.readInt();
                j21Var.f = i4;
                if (i4 > 0) {
                    int[] iArr3 = new int[i4];
                    j21Var.g = iArr3;
                    parcel.readIntArray(iArr3);
                }
                j21Var.i = parcel.readInt() == 1;
                j21Var.j = parcel.readInt() == 1;
                j21Var.k = parcel.readInt() == 1;
                j21Var.h = parcel.readArrayList(i21.class.getClassLoader());
                return j21Var;
            case 10:
                return new db1(parcel);
            case 11:
                int iT = fc0.T(parcel);
                while (true) {
                    ArrayList arrayListCreateTypedArrayList = null;
                    while (parcel.dataPosition() < iT) {
                        int i5 = parcel.readInt();
                        char c = (char) i5;
                        if (c == 1) {
                            iJ = fc0.J(parcel, i5);
                        } else if (c != 2) {
                            fc0.Q(parcel, i5);
                        } else {
                            Parcelable.Creator<xl0> creator = xl0.CREATOR;
                            int iK = fc0.K(parcel, i5);
                            int iDataPosition = parcel.dataPosition();
                            if (iK == 0) {
                            }
                            arrayListCreateTypedArrayList = parcel.createTypedArrayList(creator);
                            parcel.setDataPosition(iDataPosition + iK);
                        }
                        break;
                    }
                    fc0.q(parcel, iT);
                    return new q41(iJ, arrayListCreateTypedArrayList);
                }
                break;
            case 12:
                int iT2 = fc0.T(parcel);
                int iJ2 = 0;
                while (parcel.dataPosition() < iT2) {
                    int i6 = parcel.readInt();
                    char c2 = (char) i6;
                    if (c2 == 1) {
                        iJ = fc0.J(parcel, i6);
                    } else if (c2 == 2) {
                        iJ2 = fc0.J(parcel, i6);
                    } else if (c2 != 3) {
                        fc0.Q(parcel, i6);
                    } else {
                        intent = (Intent) fc0.k(parcel, i6, Intent.CREATOR);
                    }
                }
                fc0.q(parcel, iT2);
                return new hj1(iJ, iJ2, intent);
            case 13:
                int iT3 = fc0.T(parcel);
                long j = 0;
                String strL4 = null;
                String strL5 = null;
                String strL6 = null;
                String strL7 = null;
                Uri uri = null;
                String strL8 = null;
                String strL9 = null;
                ArrayList arrayList = null;
                String strL10 = null;
                String strL11 = null;
                int iJ3 = 0;
                while (parcel.dataPosition() < iT3) {
                    int i7 = parcel.readInt();
                    switch ((char) i7) {
                        case 1:
                            iJ3 = fc0.J(parcel, i7);
                            break;
                        case 2:
                            strL4 = fc0.l(parcel, i7);
                            break;
                        case 3:
                            strL5 = fc0.l(parcel, i7);
                            break;
                        case 4:
                            strL6 = fc0.l(parcel, i7);
                            break;
                        case 5:
                            strL7 = fc0.l(parcel, i7);
                            break;
                        case 6:
                            uri = (Uri) fc0.k(parcel, i7, Uri.CREATOR);
                            break;
                        case 7:
                            strL8 = fc0.l(parcel, i7);
                            break;
                        case '\b':
                            fc0.W(parcel, i7, 8);
                            j = parcel.readLong();
                            break;
                        case '\t':
                            strL9 = fc0.l(parcel, i7);
                            break;
                        case '\n':
                            Parcelable.Creator<Scope> creator2 = Scope.CREATOR;
                            int iK2 = fc0.K(parcel, i7);
                            int iDataPosition2 = parcel.dataPosition();
                            if (iK2 != 0) {
                                ArrayList arrayListCreateTypedArrayList2 = parcel.createTypedArrayList(creator2);
                                parcel.setDataPosition(iDataPosition2 + iK2);
                                arrayList = arrayListCreateTypedArrayList2;
                            } else {
                                arrayList = null;
                            }
                            break;
                        case 11:
                            strL10 = fc0.l(parcel, i7);
                            break;
                        case '\f':
                            strL11 = fc0.l(parcel, i7);
                            break;
                        default:
                            fc0.Q(parcel, i7);
                            break;
                    }
                }
                fc0.q(parcel, iT3);
                return new GoogleSignInAccount(iJ3, strL4, strL5, strL6, strL7, uri, strL8, j, strL9, arrayList, strL10, strL11);
            case 14:
                int iT4 = fc0.T(parcel);
                ArrayList<String> arrayList2 = null;
                String strL12 = null;
                while (parcel.dataPosition() < iT4) {
                    int i8 = parcel.readInt();
                    char c3 = (char) i8;
                    if (c3 == 1) {
                        int iK3 = fc0.K(parcel, i8);
                        int iDataPosition3 = parcel.dataPosition();
                        if (iK3 == 0) {
                            arrayList2 = null;
                        } else {
                            ArrayList<String> arrayListCreateStringArrayList = parcel.createStringArrayList();
                            parcel.setDataPosition(iDataPosition3 + iK3);
                            arrayList2 = arrayListCreateStringArrayList;
                        }
                    } else if (c3 != 2) {
                        fc0.Q(parcel, i8);
                    } else {
                        strL12 = fc0.l(parcel, i8);
                    }
                }
                fc0.q(parcel, iT4);
                return new bk1(strL12, arrayList2);
            case 15:
                int iT5 = fc0.T(parcel);
                lk1 lk1Var = null;
                while (parcel.dataPosition() < iT5) {
                    int i9 = parcel.readInt();
                    char c4 = (char) i9;
                    if (c4 == 1) {
                        iJ = fc0.J(parcel, i9);
                    } else if (c4 == 2) {
                        xmVar = (xm) fc0.k(parcel, i9, xm.CREATOR);
                    } else if (c4 != 3) {
                        fc0.Q(parcel, i9);
                    } else {
                        lk1Var = (lk1) fc0.k(parcel, i9, lk1.CREATOR);
                    }
                }
                fc0.q(parcel, iT5);
                return new fk1(iJ, xmVar, lk1Var);
            case 16:
                int iT6 = fc0.T(parcel);
                long j2 = 0;
                long j3 = 0;
                int iJ4 = -1;
                String strL13 = null;
                String strL14 = null;
                int iJ5 = 0;
                int iJ6 = 0;
                int iJ7 = 0;
                int iJ8 = 0;
                while (parcel.dataPosition() < iT6) {
                    int i10 = parcel.readInt();
                    switch ((char) i10) {
                        case 1:
                            iJ5 = fc0.J(parcel, i10);
                            break;
                        case 2:
                            iJ6 = fc0.J(parcel, i10);
                            break;
                        case 3:
                            iJ7 = fc0.J(parcel, i10);
                            break;
                        case 4:
                            fc0.W(parcel, i10, 8);
                            j2 = parcel.readLong();
                            break;
                        case 5:
                            fc0.W(parcel, i10, 8);
                            j3 = parcel.readLong();
                            break;
                        case 6:
                            strL13 = fc0.l(parcel, i10);
                            break;
                        case 7:
                            strL14 = fc0.l(parcel, i10);
                            break;
                        case '\b':
                            iJ8 = fc0.J(parcel, i10);
                            break;
                        case '\t':
                            iJ4 = fc0.J(parcel, i10);
                            break;
                        default:
                            fc0.Q(parcel, i10);
                            break;
                    }
                }
                fc0.q(parcel, iT6);
                return new xl0(iJ5, iJ6, iJ7, j2, j3, strL13, strL14, iJ8, iJ4);
            case 17:
                int iT7 = fc0.T(parcel);
                GoogleSignInAccount googleSignInAccount = null;
                int iJ9 = 0;
                while (parcel.dataPosition() < iT7) {
                    int i11 = parcel.readInt();
                    char c5 = (char) i11;
                    if (c5 == 1) {
                        iJ = fc0.J(parcel, i11);
                    } else if (c5 == 2) {
                        account = (Account) fc0.k(parcel, i11, Account.CREATOR);
                    } else if (c5 == 3) {
                        iJ9 = fc0.J(parcel, i11);
                    } else if (c5 != 4) {
                        fc0.Q(parcel, i11);
                    } else {
                        googleSignInAccount = (GoogleSignInAccount) fc0.k(parcel, i11, GoogleSignInAccount.CREATOR);
                    }
                }
                fc0.q(parcel, iT7);
                return new jk1(iJ, account, iJ9, googleSignInAccount);
            case 18:
                int iT8 = fc0.T(parcel);
                IBinder iBinder = null;
                xm xmVar2 = null;
                int iJ10 = 0;
                boolean zI = false;
                boolean zI2 = false;
                while (parcel.dataPosition() < iT8) {
                    int i12 = parcel.readInt();
                    char c6 = (char) i12;
                    if (c6 == 1) {
                        iJ10 = fc0.J(parcel, i12);
                    } else if (c6 == 2) {
                        int iK4 = fc0.K(parcel, i12);
                        int iDataPosition4 = parcel.dataPosition();
                        if (iK4 == 0) {
                            iBinder = null;
                        } else {
                            IBinder strongBinder2 = parcel.readStrongBinder();
                            parcel.setDataPosition(iDataPosition4 + iK4);
                            iBinder = strongBinder2;
                        }
                    } else if (c6 == 3) {
                        xmVar2 = (xm) fc0.k(parcel, i12, xm.CREATOR);
                    } else if (c6 == 4) {
                        zI = fc0.I(parcel, i12);
                    } else if (c6 != 5) {
                        fc0.Q(parcel, i12);
                    } else {
                        zI2 = fc0.I(parcel, i12);
                    }
                }
                fc0.q(parcel, iT8);
                return new lk1(iJ10, iBinder, xmVar2, zI, zI2);
            case 19:
                int iT9 = fc0.T(parcel);
                while (parcel.dataPosition() < iT9) {
                    int i13 = parcel.readInt();
                    char c7 = (char) i13;
                    if (c7 == 1) {
                        iJ = fc0.J(parcel, i13);
                    } else if (c7 != 2) {
                        fc0.Q(parcel, i13);
                    } else {
                        strL3 = fc0.l(parcel, i13);
                    }
                }
                fc0.q(parcel, iT9);
                return new Scope(strL3, iJ);
            case 20:
                int iT10 = fc0.T(parcel);
                int iJ11 = 0;
                int iJ12 = 0;
                int iJ13 = 0;
                boolean zI3 = false;
                boolean zI4 = false;
                while (parcel.dataPosition() < iT10) {
                    int i14 = parcel.readInt();
                    char c8 = (char) i14;
                    if (c8 == 1) {
                        iJ11 = fc0.J(parcel, i14);
                    } else if (c8 == 2) {
                        zI3 = fc0.I(parcel, i14);
                    } else if (c8 == 3) {
                        zI4 = fc0.I(parcel, i14);
                    } else if (c8 == 4) {
                        iJ12 = fc0.J(parcel, i14);
                    } else if (c8 != 5) {
                        fc0.Q(parcel, i14);
                    } else {
                        iJ13 = fc0.J(parcel, i14);
                    }
                }
                fc0.q(parcel, iT10);
                return new pw0(iJ11, iJ12, iJ13, zI3, zI4);
            case 21:
                int iT11 = fc0.T(parcel);
                PendingIntent pendingIntent2 = null;
                xm xmVar3 = null;
                while (parcel.dataPosition() < iT11) {
                    int i15 = parcel.readInt();
                    char c9 = (char) i15;
                    if (c9 == 1) {
                        iJ = fc0.J(parcel, i15);
                    } else if (c9 == 2) {
                        strL2 = fc0.l(parcel, i15);
                    } else if (c9 == 3) {
                        pendingIntent2 = (PendingIntent) fc0.k(parcel, i15, PendingIntent.CREATOR);
                    } else if (c9 != 4) {
                        fc0.Q(parcel, i15);
                    } else {
                        xmVar3 = (xm) fc0.k(parcel, i15, xm.CREATOR);
                    }
                }
                fc0.q(parcel, iT11);
                return new Status(iJ, strL2, pendingIntent2, xmVar3);
            case 22:
                int iT12 = fc0.T(parcel);
                String strL15 = null;
                int iJ14 = 0;
                while (parcel.dataPosition() < iT12) {
                    int i16 = parcel.readInt();
                    char c10 = (char) i16;
                    if (c10 == 1) {
                        iJ = fc0.J(parcel, i16);
                    } else if (c10 == 2) {
                        iJ14 = fc0.J(parcel, i16);
                    } else if (c10 == 3) {
                        pendingIntent = (PendingIntent) fc0.k(parcel, i16, PendingIntent.CREATOR);
                    } else if (c10 != 4) {
                        fc0.Q(parcel, i16);
                    } else {
                        strL15 = fc0.l(parcel, i16);
                    }
                }
                fc0.q(parcel, iT12);
                return new xm(iJ, iJ14, pendingIntent, strL15);
            case 23:
                int iT13 = fc0.T(parcel);
                long j4 = -1;
                while (parcel.dataPosition() < iT13) {
                    int i17 = parcel.readInt();
                    char c11 = (char) i17;
                    if (c11 == 1) {
                        strL = fc0.l(parcel, i17);
                    } else if (c11 == 2) {
                        iJ = fc0.J(parcel, i17);
                    } else if (c11 != 3) {
                        fc0.Q(parcel, i17);
                    } else {
                        fc0.W(parcel, i17, 8);
                        j4 = parcel.readLong();
                    }
                }
                fc0.q(parcel, iT13);
                return new l10(strL, iJ, j4);
            case 24:
                int iT14 = fc0.T(parcel);
                Bundle bundle = null;
                l10[] l10VarArr = null;
                bn bnVar = null;
                while (parcel.dataPosition() < iT14) {
                    int i18 = parcel.readInt();
                    char c12 = (char) i18;
                    if (c12 == 1) {
                        int iK5 = fc0.K(parcel, i18);
                        int iDataPosition5 = parcel.dataPosition();
                        if (iK5 == 0) {
                            bundle = null;
                        } else {
                            Bundle bundle2 = parcel.readBundle();
                            parcel.setDataPosition(iDataPosition5 + iK5);
                            bundle = bundle2;
                        }
                    } else if (c12 == 2) {
                        l10VarArr = (l10[]) fc0.m(parcel, i18, l10.CREATOR);
                    } else if (c12 == 3) {
                        iJ = fc0.J(parcel, i18);
                    } else if (c12 != 4) {
                        fc0.Q(parcel, i18);
                    } else {
                        bnVar = (bn) fc0.k(parcel, i18, bn.CREATOR);
                    }
                }
                fc0.q(parcel, iT14);
                tq1 tq1Var = new tq1();
                tq1Var.b = bundle;
                tq1Var.c = l10VarArr;
                tq1Var.d = iJ;
                tq1Var.e = bnVar;
                return tq1Var;
            case 25:
                int iT15 = fc0.T(parcel);
                pw0 pw0Var = null;
                int[] iArr4 = null;
                int[] iArr5 = null;
                boolean zI5 = false;
                boolean zI6 = false;
                int iJ15 = 0;
                while (parcel.dataPosition() < iT15) {
                    int i19 = parcel.readInt();
                    switch ((char) i19) {
                        case 1:
                            pw0Var = (pw0) fc0.k(parcel, i19, pw0.CREATOR);
                            break;
                        case 2:
                            zI5 = fc0.I(parcel, i19);
                            break;
                        case 3:
                            zI6 = fc0.I(parcel, i19);
                            break;
                        case 4:
                            int iK6 = fc0.K(parcel, i19);
                            int iDataPosition6 = parcel.dataPosition();
                            if (iK6 != 0) {
                                int[] iArrCreateIntArray = parcel.createIntArray();
                                parcel.setDataPosition(iDataPosition6 + iK6);
                                iArr4 = iArrCreateIntArray;
                            } else {
                                iArr4 = null;
                            }
                            break;
                        case 5:
                            iJ15 = fc0.J(parcel, i19);
                            break;
                        case 6:
                            int iK7 = fc0.K(parcel, i19);
                            int iDataPosition7 = parcel.dataPosition();
                            if (iK7 != 0) {
                                int[] iArrCreateIntArray2 = parcel.createIntArray();
                                parcel.setDataPosition(iDataPosition7 + iK7);
                                iArr5 = iArrCreateIntArray2;
                            } else {
                                iArr5 = null;
                            }
                            break;
                        default:
                            fc0.Q(parcel, i19);
                            break;
                    }
                }
                fc0.q(parcel, iT15);
                return new bn(pw0Var, zI5, zI6, iArr4, iJ15, iArr5);
            default:
                int iT16 = fc0.T(parcel);
                Bundle bundle3 = new Bundle();
                Scope[] scopeArr = p60.p;
                l10[] l10VarArr2 = p60.q;
                l10[] l10VarArr3 = l10VarArr2;
                String strL16 = null;
                IBinder iBinder2 = null;
                Account account2 = null;
                String strL17 = null;
                int iJ16 = 0;
                int iJ17 = 0;
                int iJ18 = 0;
                boolean zI7 = false;
                int iJ19 = 0;
                boolean zI8 = false;
                while (parcel.dataPosition() < iT16) {
                    int i20 = parcel.readInt();
                    switch ((char) i20) {
                        case 1:
                            iJ16 = fc0.J(parcel, i20);
                            break;
                        case 2:
                            iJ17 = fc0.J(parcel, i20);
                            break;
                        case 3:
                            iJ18 = fc0.J(parcel, i20);
                            break;
                        case 4:
                            strL16 = fc0.l(parcel, i20);
                            break;
                        case 5:
                            int iK8 = fc0.K(parcel, i20);
                            int iDataPosition8 = parcel.dataPosition();
                            if (iK8 != 0) {
                                IBinder strongBinder3 = parcel.readStrongBinder();
                                parcel.setDataPosition(iDataPosition8 + iK8);
                                iBinder2 = strongBinder3;
                            } else {
                                iBinder2 = null;
                            }
                            break;
                        case 6:
                            scopeArr = (Scope[]) fc0.m(parcel, i20, Scope.CREATOR);
                            break;
                        case 7:
                            int iK9 = fc0.K(parcel, i20);
                            int iDataPosition9 = parcel.dataPosition();
                            if (iK9 != 0) {
                                Bundle bundle4 = parcel.readBundle();
                                parcel.setDataPosition(iDataPosition9 + iK9);
                                bundle3 = bundle4;
                            } else {
                                bundle3 = null;
                            }
                            break;
                        case '\b':
                            account2 = (Account) fc0.k(parcel, i20, Account.CREATOR);
                            break;
                        case '\t':
                        default:
                            fc0.Q(parcel, i20);
                            break;
                        case '\n':
                            l10VarArr2 = (l10[]) fc0.m(parcel, i20, l10.CREATOR);
                            break;
                        case 11:
                            l10VarArr3 = (l10[]) fc0.m(parcel, i20, l10.CREATOR);
                            break;
                        case '\f':
                            zI7 = fc0.I(parcel, i20);
                            break;
                        case '\r':
                            iJ19 = fc0.J(parcel, i20);
                            break;
                        case 14:
                            zI8 = fc0.I(parcel, i20);
                            break;
                        case 15:
                            strL17 = fc0.l(parcel, i20);
                            break;
                    }
                }
                fc0.q(parcel, iT16);
                return new p60(iJ16, iJ17, iJ18, strL16, iBinder2, scopeArr, bundle3, account2, l10VarArr2, l10VarArr3, zI7, iJ19, zI8, strL17);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        switch (this.a) {
            case 0:
                return new ParcelImpl[i];
            case 1:
                return new ParcelableVolumeInfo[i];
            case 2:
                return new PlaybackStateCompat[i];
            case 3:
                return new yp0[i];
            case 4:
                return new hq0[i];
            case 5:
                return new RatingCompat[i];
            case 6:
                return new lw0[i];
            case 7:
                return new uy0[i];
            case 8:
                return new i21[i];
            case 9:
                return new j21[i];
            case 10:
                return new db1[i];
            case 11:
                return new q41[i];
            case 12:
                return new hj1[i];
            case 13:
                return new GoogleSignInAccount[i];
            case 14:
                return new bk1[i];
            case 15:
                return new fk1[i];
            case 16:
                return new xl0[i];
            case 17:
                return new jk1[i];
            case 18:
                return new lk1[i];
            case 19:
                return new Scope[i];
            case 20:
                return new pw0[i];
            case 21:
                return new Status[i];
            case 22:
                return new xm[i];
            case 23:
                return new l10[i];
            case 24:
                return new tq1[i];
            case 25:
                return new bn[i];
            default:
                return new p60[i];
        }
    }
}
