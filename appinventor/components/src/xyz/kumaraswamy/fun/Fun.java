    package xyz.kumaraswamy.fun;

import com.google.appinventor.components.runtime.AndroidNonvisibleComponent;
import com.google.appinventor.components.runtime.ComponentContainer;
import com.google.appinventor.components.runtime.errors.YailRuntimeError;
import com.google.appinventor.components.runtime.util.YailList;
import gnu.lists.LList;
import gnu.mapping.Procedure;
import gnu.mapping.ProcedureN;
import gnu.mapping.Symbol;
import java.util.HashMap;
import java.util.Iterator;

public class Fun extends AndroidNonvisibleComponent {
   private static final HashMap a = new HashMap();

   public Fun(ComponentContainer var1) {
      super(var1.$form());
      this.a();
   }

   private void a() {
      LList var1 = (LList)this.form.getClass().getField("global$Mnvars$Mnto$Mncreate").get(this.form);
      HashMap var2 = new HashMap();
      Iterator var5 = var1.iterator();

      while(var5.hasNext()) {
         Object var3 = var5.next();
         if (!LList.Empty.equals(var3)) {
            LList var6;
            Object var4 = (var6 = (LList)var3).get(1);
            var2.put(((Symbol)var6.get(0)).getName(), (ProcedureN)var4);
         }
      }

      a.put(this.form.getClass().getSimpleName(), var2);
   }

   public Object Invoke(String var1, String var2, YailList var3) {
      HashMap var4;
      if ((var4 = (HashMap)a.get(var1)) == null) {
         throw new YailRuntimeError("Unable to find screen '" + var1 + "'", "Fun");
      } else {
         Procedure var5;
         if ((var5 = (Procedure)var4.get("p$".concat(String.valueOf(var2)))) == null) {
            throw new YailRuntimeError("Unable to find procedure '" + var2 + "'", "Fun");
         } else {
            return ((ProcedureN)var5.apply0()).applyN(var3.toArray());
         }
      }
   }
}