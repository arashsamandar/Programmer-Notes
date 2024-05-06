## Two types Of Tests

> we have two types of tests
>
> 1. Unit test : that tests a small pieace of code ( like a method or etc )
> 2. Feature test : which tests larger portion of the application , like Objects interacting or sending a full json object to an end-point

- *describe*

  > use `describe` to group related test together

- *test* or *it*

  > `test` and `it` are aliases you can use each one you like

```javascript
describe('My Beverage', () => {
  test('is delicious', () => {
    expect(myBeverage.delicious).toBeTruthy();
  });

  it('is not sour', () => {
    expect(myBeverage.sour).toBeFalsy();
  });
});
```

- files ends with `.test` or `.spec` , ( of course usually )
- `expect` or `assert` for testing the code , like `expect` in `js jest` and `assert` in `phpUnit` and `Laravel`