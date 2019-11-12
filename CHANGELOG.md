# Changelog

## Release 1.0.2 *(2019-11-12)*

 * (Enhancement) The data structure used for data cache is now thread-safe.
 * (Fix) `SharedPreferences` could cause a NullPointerException when persisting cookies contained null data.

## Release 1.0.1 *(2017-01-24)*

 * (Fix) `SharedPreferences` could cause a NullPointerException when persisting cookies contained invalid data.

## Release 1.0.0 *(2016-08-23)*

 * (New) New `ClearableCookieJar.clearSession()` method to clear session cookies from the jar while maintaining persisted cookies.
 * (New) New `SharedPrefsCookiePersistor` constructor that accepts a `SharedPreferences` object.
 * (Enhancement) Some minor changes in `SetCookieCache` and `SharedPrefsCookiePersistor` implementations.

## Release 0.9.3 *(2016-04-25)*

 * (Enhancement) Added ProGuard rules.

## Release 0.9.2 *(2016-04-11)*

 * (Fix) Streams closed when encoding and decoding `SerializableCookie`.

## Release 0.9.1 *(2016-04-11)*

 * (Fix) Added a fixed serialVersionUID to `SerializableCookie` to avoid problems when it is generated and instant run is activated.

## Release 0.9.0 *(2016-02-17)*

 * Initial release.