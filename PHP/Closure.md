> a `Closure` is an `anonymus` function that can't access the exteran scop ( exteran variables )

> NOTE : if you want a closure to have access to a outside sources ( Variables ) , you must define it like bellow

```markdown
$request = new Request();
function($message) use($requesst) {

}
```