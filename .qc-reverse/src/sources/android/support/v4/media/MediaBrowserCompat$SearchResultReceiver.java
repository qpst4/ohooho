package android.support.v4.media;

import android.os.Bundle;
import android.os.Parcelable;
import defpackage.lw0;
import defpackage.tk0;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
class MediaBrowserCompat$SearchResultReceiver extends lw0 {
    @Override // defpackage.lw0
    public final void a(int i, Bundle bundle) {
        Parcelable[] parcelableArray;
        if (bundle != null) {
            bundle.setClassLoader(tk0.class.getClassLoader());
        }
        if (i != 0 || bundle == null || !bundle.containsKey("search_results") || (parcelableArray = bundle.getParcelableArray("search_results")) == null) {
            throw null;
        }
        ArrayList arrayList = new ArrayList();
        for (Parcelable parcelable : parcelableArray) {
            arrayList.add((MediaBrowserCompat$MediaItem) parcelable);
        }
        throw null;
    }
}
