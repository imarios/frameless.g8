### About

A [Giter8][g8] template for [frameless](https://github.com/adelbertc/frameless)!

### Create an sbt project

If you have [Giter8][g8] then simply:

```bash
g8 imarios/frameless.g8
```

With sbt >= 0.13.13:

```bash
sbt new imarios/frameless.g8
```

### Use the project

Run a simple example

```bash
sbt run
```

Bring up a REPL with frameless pre-loaded and ready to experiment:

```
sbt console
```

When the REPL loads, try a simple example:

```bash
scala> val fTypedDataset = TypedDataset.create( (1, "a", true) ::  (10, "b", false) :: (1, "c", true) :: Nil)
scala> fTypedDataset.show().run()
```

Follow the frameless [documentation](https://github.com/adelbertc/frameless#documentation)
for more examples.


Template license
----------------
Written in 2017 by Marios Iliofotou (iliofotou@gmail.com)

To the extent possible under law, the author(s) have dedicated all copyright and related
and neighboring rights to this template to the public domain worldwide.
This template is distributed without any warranty. See <http://creativecommons.org/publicdomain/zero/1.0/>.

[g8]: http://www.foundweekends.org/giter8/
