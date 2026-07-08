# 1. Two Sum

> **Difficulty:** 🟢 Easy  
> **Topics:** Array, Hash Table

## Problem Statement

Given an array of integers `nums` and an integer `target`, return the **indices** of the two numbers such that they add up to `target`.

You may assume that:

- Each input has **exactly one solution**.
- You may **not use the same element twice**.
- The answer can be returned in **any order**.

---

## Examples

### Example 1

**Input**

```text
nums = [2,7,11,15], target = 9
```

**Output**

```text
[0,1]
```

**Explanation**

```
nums[0] + nums[1] = 2 + 7 = 9
```

---

### Example 2

**Input**

```text
nums = [3,2,4], target = 6
```

**Output**

```text
[1,2]
```

---

### Example 3

**Input**

```text
nums = [3,3], target = 6
```

**Output**

```text
[0,1]
```

---

## Constraints

- `2 <= nums.length <= 10⁴`
- `-10⁹ <= nums[i] <= 10⁹`
- `-10⁹ <= target <= 10⁹`
- Exactly one valid answer exists.

---

# Approach

## Intuition

A brute-force solution checks every pair of elements, resulting in **O(n²)** time complexity.

To optimize this, we use a **Hash Map** to store previously visited numbers and their indices.

For each element:

1. Compute its complement:
   ```
   complement = target - nums[i]
   ```
2. Check whether the complement already exists in the hash map.
3. If it exists, we've found the required pair.
4. Otherwise, store the current element and continue.

This allows us to find the answer in a single traversal.

---

## Algorithm

1. Create an empty hash map.
2. Iterate through the array.
3. For each element:
   - Calculate the complement.
   - If the complement exists in the map, return both indices.
   - Otherwise, insert the current number and its index into the map.
4. Since the problem guarantees exactly one solution, a valid pair will always be found.

---

## Complexity Analysis

| Metric | Complexity |
|---------|------------|
| Time | **O(n)** |
| Space | **O(n)** |

- Each element is processed only once.
- Hash map operations take **O(1)** on average.

---

## Python Solution
[`Solution.py`](Solution.py)

---

## Key Takeaways

- A hash map enables constant-time lookups.
- Store previously visited elements while traversing the array.
- This reduces the time complexity from **O(n²)** to **O(n)**.
- The approach is efficient and commonly used for lookup-based problems.

---
