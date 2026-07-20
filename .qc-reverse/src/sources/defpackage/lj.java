package defpackage;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ProgressBar;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class lj extends AsyncTask {
    public final Context a;
    public final ProgressBar b;
    public final mj c;
    public final kj d;

    public lj(Context context, ProgressBar progressBar, mj mjVar, kj kjVar) {
        this.a = context;
        this.b = progressBar;
        this.c = mjVar;
        this.d = kjVar;
    }

    @Override // android.os.AsyncTask
    public final Object doInBackground(Object[] objArr) {
        try {
            kj kjVar = this.d;
            if (kjVar != null) {
                return kjVar.a(this.a);
            }
            return null;
        } catch (Exception e) {
            Log.e("Changelog Library", "Exception occured while building changelog's RecyclerView items", e);
            return null;
        }
    }

    @Override // android.os.AsyncTask
    public final void onPostExecute(Object obj) {
        List list = (List) obj;
        if (list != null) {
            mj mjVar = this.c;
            mjVar.e = list;
            mjVar.d();
        }
        ProgressBar progressBar = this.b;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
    }
}
