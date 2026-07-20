package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.quickcursor.R;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class kj implements Parcelable {
    public static final Parcelable.Creator CREATOR = new c4(7);
    public int b = -1;
    public boolean c = false;
    public rj d = new rj();
    public zr e;
    public boolean f;
    public boolean g;
    public boolean h;
    public String i;
    public String j;
    public String k;
    public int l;
    public boolean m;

    public kj() {
        zr zrVar = new zr();
        zrVar.b = 1;
        zrVar.c = "";
        this.e = zrVar;
        this.l = R.raw.changelog;
        this.m = false;
        this.f = false;
        this.g = false;
        this.h = false;
        this.i = null;
        this.j = null;
        this.k = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00e8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.ArrayList a(android.content.Context r8) {
        /*
            Method dump skipped, instruction units count: 307
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.kj.a(android.content.Context):java.util.ArrayList");
    }

    public final mj b(RecyclerView recyclerView) {
        mj mjVar = new mj(recyclerView.getContext(), this, new ArrayList());
        recyclerView.getContext();
        recyclerView.setLayoutManager(new LinearLayoutManager(1));
        recyclerView.setAdapter(mjVar);
        return mjVar;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.b);
        parcel.writeByte(this.c ? (byte) 1 : (byte) 0);
        parcel.writeByte((byte) 0);
        parcel.writeByte((byte) 0);
        rj rjVar = this.d;
        parcel.writeString(rjVar.getClass().getCanonicalName());
        parcel.writeParcelable(rjVar, 0);
        zr zrVar = this.e;
        parcel.writeString(zrVar.getClass().getCanonicalName());
        parcel.writeParcelable(zrVar, 0);
        parcel.writeInt(this.l);
        parcel.writeByte(this.m ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.g ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.h ? (byte) 1 : (byte) 0);
        parcel.writeString(this.i);
        parcel.writeString(this.j);
        parcel.writeString(this.k);
    }
}
