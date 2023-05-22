## Adding Local Repository To GitHub

```
git init -b main // initialization

git add . && git commit -m "Initial Commit"
```

> more on that in bellow link :

https://docs.github.com/en/get-started/importing-your-projects-to-github/importing-source-code-to-github/adding-locally-hosted-code-to-github

> if you got any error , just use bellow code :

```
git push 
```

> if you want to see your `story of commitments` simply type :
>
> ```
> git log
> ```

## Create a branch and push to it

> first create the `branch` with the following code :

```
git branch my-new-branch;
```

> then go to that branch with bellow command :

```
git checkout my-new-branch
```

> then push to new branch like bellow :

```
git push -u origin my-new-branch
```

### Deleting a branch

> you can delete a branch with bellow command :

```
git branch -d your-branch
```

### git merge

> after you created several `branch` , and commiting on them , they are infact branches beside `main` or `master` branch .
>
> so first go to the `main` branch with
>
> ```
> git checkout main
> ```
>
> after that merge with that branch , when we are in main branch , merge main with newest branch and make it up to date with bellow code :
>
> ```
> git checkout main
> // or
> git checkout -b main
> // then
> gi
> ```
>

---------

#### Using Git Tag

> you can use `git tag` to create and add a `tag` to your `commit` , like so :arrow_double_down:

```
---A---B---C---o---o---o   master

git checkout master
git checkout A~0
git add path/to/file
git commit --date='whenever'
git tag ,new-commit -m'delete me later'
git checkout -
git rebase --onto ,new-commit A
git tag -d ,new-commit

---A---N                      (was ",new-commit", but we delete the tag)
        \
         B'---C'---o---o---o   master
```

## Learn what is the difference between `Git pull` & `Git Clone` & maybe `Git rebase`
