# chronograph

Browser clock implemented in [Quil] that renders a mark for every *pars minuta
tertia* of the current minute.

[Quil]: http://quil.info

## Usage

The [Boot] build tool needs to be installed in order to compile [ClojureScript]
sources and bundle related resources.

Build an optimized production bundle:

```sh
boot build
```

Serve the contents of `target/public/`:

```sh
boot -d pandeiro/boot-http serve -d ./target/public/ wait
```

Open [localhost:3000](http://localhost:3000) inside a browser.

[Boot]: http://boot-clj.com
[ClojureScript]: https://clojurescript.org

---
Copyright © 2017 Tibor Claassen. Distributed under the MIT License.
