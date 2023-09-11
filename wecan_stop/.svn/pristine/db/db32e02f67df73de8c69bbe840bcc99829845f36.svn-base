package {

  /**
   * Utility methods for XSS attack prevention.
   */
  internal class XssUtils {

    /**
     * Sanitize a string to avoid XSS vulnerabilities.
     *
     * @return an XSS safe String
     * @static
    */
    public static function sanitizeString(dirty:String): String {
      return (typeof dirty === "string" && dirty) ? dirty.replace(/\\/g, "\\\\") : "";
    }


    /**
     * Sanitize the Loader param by filtering out all URL query param,
     * leaving ONLY param that were specified via FlashVars in the HTML
     * embedding markup.
     *
     * @return a filtered param object, a.k.a. FlashVars
     * @static
     */
    public static function filterToFlashVars(
      parameters:Object  // NOPMD
    ): Object {  // NOPMD
      //
      // TODO: Implement this for real
      // See:  https://github.com/zeroclipboard/zeroclipboard/pull/336
      //
      return parameters;
    }

  }
}